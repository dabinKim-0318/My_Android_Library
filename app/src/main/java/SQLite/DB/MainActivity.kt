package SQLite.DB


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_study.databinding.ActivityMain4Binding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMain4Binding

    //memo라는 파일이름가진 데베랑 memo테이블 생성
    val helper = SqliteHelper(this, "hi", 1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = RecyclerAdapter()
        //메모 삭제하려면 SQLite에 있는 데이터, 어댑터에 있는 컬렉션 데이터를 모두 삭제해야함
        //adapter에게 helper를 전달함
         adapter.helper = helper

        //리스트에 데베에서 가져온 값 넣기
        adapter.listData.addAll(helper.selectMemo())
        //어댑터 연결+레이아웃 매니저지정
        binding.recyclerMemo.adapter = adapter
        binding.recyclerMemo.layoutManager = LinearLayoutManager(this)

        binding.buttonSave.setOnClickListener {
            //플레인 텍스트 검사해서 값이 있으면 Memo클래스 생성
            if (binding.editMemo.text.isNotEmpty()) {
                val memo = Memo(null, binding.editMemo.text.toString(), System.currentTimeMillis())
                helper.insertMemo(memo)

                //리스트 싹지우고 다시 리스트에 데베에서 가져온 값 넣기->무식한방법
                adapter.listData.clear()
                adapter.listData.addAll(helper.selectMemo())
                //리스트 변경되엇음을 어댑터에게 알리기
                adapter.notifyDataSetChanged()
                binding.editMemo.setText("")
            }
        }
    }
}