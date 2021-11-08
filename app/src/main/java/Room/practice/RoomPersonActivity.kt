package Room.practice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.kotlin_study.databinding.ActivityRoomPersonBinding

class RoomPersonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRoomPersonBinding
    private lateinit var helper: RoomHelperPerson
    var personList= mutableListOf<RoomPerson>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRoomPersonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //RoomDB를 빌드 해보자
        //databaseBuilder(context,Helper클래스,데베 이름)
        helper = Room.databaseBuilder(this, RoomHelperPerson::class.java, "room_person_db")
            .allowMainThreadQueries() //공부할때만 쓴다 main쓰레드에서 쿼리를 날린다 원래 main에서 쿼리 날리면 안되는데
            .build()  //build가 실행되는 순간 RoomHelper클래스를 사용할수있게 알아서 코드 채워서 전달해줌

        //데베에서 목록을 가져와서 뿌린다
        personList.addAll(helper.roomPersonDao().getAll())

        //어댑터 연결
        val adapter = RoomPersonAdapter(personList)
        binding.rvRoom.adapter = adapter
        binding.rvRoom.layoutManager = LinearLayoutManager(this)
        adapter.notifyDataSetChanged()

        //저장버튼을 누르면 리스트를 갱신한다
        binding.bvSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val phone = binding.etAddress.text.toString()
            val address = binding.etPhone.text.toString()
            if (name.isNotEmpty() && phone.isNotEmpty() && address.isNotEmpty()) {
                helper.roomPersonDao().insert(RoomPerson(name, phone, address))
                personList.clear()
                personList.addAll(helper.roomPersonDao().getAll())
                adapter.notifyDataSetChanged()
                binding.etAddress.setText("")
                binding.etName.setText("")
                binding.etPhone.setText("")
            }
        }
    }
}