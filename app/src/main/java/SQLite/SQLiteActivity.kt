package SQLite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_study.databinding.ActivityMain3Binding

class SQLiteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    private val helper = SqliteHelper(this, DB_NAME, DB_VERSION)

    companion object {
        const val DB_NAME = "sqlite.sql"
        const val DB_VERSION = 1
    }

    val adapter = RecyclerViewAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        // initShow()
        //   clickButton()
        val memos = helper.selectMemo()  //helper에서 데베에 있던 내용 다 긁어옴
        adapter.listData.addAll(memos) //어댑터에 데이터 연결함
        binding.rvSql.adapter = adapter
        binding.rvSql.layoutManager = LinearLayoutManager(this)

        binding.buSave.setOnClickListener {
//            val test: View =binding.buSave
//            val test2: EditText=binding.edMemo
            //binding.edMemo.toString.isNotEmpty()
            val content = binding.edMemo.toString()
            //메모를 기록했는지 확인
            if (content.isNotEmpty()) {
                //신규 생성할때는 number에는 null을 주면 된다는데 왜인가? 값을 안쓰기 때문이라는데..
                //System.currentTimeMillis()->현재시간 long타입으로 가져오기
                val memo = Memo(null, content, System.currentTimeMillis())
                helper.insertMemo(memo)
                //데이터 저장하고 메모 쓰는 부분은 다시 비워주고
                binding.edMemo.setText("")
                //리스트에 있던 데이터를 전부 지우고
                adapter.listData.clear()
                //디비에 저장된 데이터로 리스트를 다시 업데이트 한후
                adapter.listData.addAll(helper.selectMemo())
                //어댑터에게 데이터 변경을 알린다
                adapter.notifyDataSetChanged()
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        for (item in 0..adapter.listData.size) {
            helper.deleteMemo(adapter.listData[item])
        }
    }
}
/*
    private fun initShow() {
        //SqliteHelper 객체 생성후 호출되면 DB_NAME에 해당하는 거 뒤지고 없으면 DB_NAME 파일 생성함과 동시에 meno라는 테이블도 같이 생성됨
        val memos = helper.selectMemo()  //helper에서 데베에 있던 내용 다 긁어옴
        adapter.listData.addAll(memos) //어댑터에 데이터 연결함
        binding.rvSql.adapter = adapter
        binding.rvSql.layoutManager = LinearLayoutManager(this)
    }

    private fun clickButton() {
        binding.buSave.setOnClickListener {
//            val test: View =binding.buSave
//            val test2: EditText=binding.edMemo
            //binding.edMemo.toString.isNotEmpty()

            val content = binding.edMemo.toString()
            //메모를 기록했는지 확인
            if (content.isNotEmpty()) {
                //신규 생성할때는 number에는 null을 주면 된다는데 왜인가? 값을 안쓰기 때문이라는데..
                //System.currentTimeMillis()->현재시간 long타입으로 가져오기
                val memo = Memo(null, content, System.currentTimeMillis())
                helper.insertMemo(memo)
                //데이터 저장하고 메모 쓰는 부분은 다시 비워주고
                binding.edMemo.setText("")
                //리스트에 있던 데이터를 전부 지우고
                adapter.listData.clear()
                //디비에 저장된 데이터로 리스트를 다시 업데이트 한후
                adapter.listData.addAll(helper.selectMemo())
                //어댑터에게 데이터 변경을 알린다
                adapter.notifyDataSetChanged()
            }

        }
    }
}
*/

