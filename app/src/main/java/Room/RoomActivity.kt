package Room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.kotlin_study.databinding.ActivityRoomBinding

//<Helper>
//@Database(entities = arrayOf(RoomMemo::class), version = 1, exportSchema = false)
//abstract class RoomHelper : RoomDatabase() {
//    abstract fun roomMemoDao(): RoomMemoDAO
//}
//<DAO정의>
//@Dao
//interface RoomMemoDAO {
//    @Query("select * from room_memo") //조회하는 ORM은 select쿼리로 직접 지정 가능
//    fun getAll(): List<RoomMemo>  //데이터 조회->테이블 리스트 리턴함
//    @Insert(onConflict = OnConflictStrategy.REPLACE) //기존에 저장되있던 Primary key의 데이터가 업데이트되면 insert안하고 걍 업데이트 해줌
//    fun insert(memo: RoomMemo)
//    @Delete
//    fun delete(memo: RoomMemo)
//}

//<테이블 역할>
//@Entity(tableName = "room_memo")  //Entity 어노테이션을 활용해서 해당 테이블의 이름을 지정
//class RoomMemo {
//    @PrimaryKey(autoGenerate = true)  //no를 프라이머리키로 지정해서 no의 값이 없을때 자동으로 숫자 증가
//    @ColumnInfo  //컬럼으로 쓰겠다는 애너테이션
//    var no: Long? = null
//    @ColumnInfo
//    var content: String = ""
//    @ColumnInfo(name = "date")  //소스코드에선 dateTime으로 쓰고 데베에 속성에는 date라는 이름으로 지정하겠다
//    var dateTime: Long = 0
//
//    constructor(content:String, dateTime:Long){
//        this.content=content
//        this.dateTime=dateTime
//    }
//}

class RoomActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRoomBinding
    lateinit var helper: RoomHelper  //helper를 만들자
    lateinit var memoAdapter: RecyclerViewAdapter
    val memoList = mutableListOf<RoomMemo>()
    lateinit var memoDAO: RoomMemoDAO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //RoomDB를 빌드 해보자
        //databaseBuilder(context,Helper클래스,데베 이름)
        helper = Room.databaseBuilder(this, RoomHelper::class.java, "room_db")
            .allowMainThreadQueries() //공부할때만 쓴다 main쓰레드에서 쿼리를 날린다 원래 main에서 쿼리 날리면 안되는데
            .build()  //build가 실행되는 순간 RoomHelper클래스를 사용할수있게 알아서 코드 채워서 전달해줌

        memoDAO = helper.roomMemoDao()

        //데베에서 목록 가져옴
        memoList.addAll(memoDAO.getAll()) //helper에 있는 roomMemoDao메소드에 접근해서 RoomMemoDAO인터페이스타입반환하는 getAll실행
        memoAdapter = RecyclerViewAdapter(memoList)
        with(binding) {
            recyclerMemo.adapter = memoAdapter
            recyclerMemo.layoutManager = LinearLayoutManager(this@RoomActivity)  //여기서의 this는 바인딩객체 가르켜서..
        }
        refreshAdapter()

        /*   binding.recyclerMemo.adapter = memoAdapter
           binding.recyclerMemo.layoutManager = LinearLayoutManager(this)*/
        binding.buttonSave.setOnClickListener {
            val content = binding.editMemo.text.toString()
            if (content.isNotEmpty()) {
                val dateTime = System.currentTimeMillis()
                val memo = RoomMemo(content, dateTime)
                memoDAO.insert(memo)  //데베에 메모 내용 집어넣고 끝나는게 아니라 집어넣은거 화면에 뿌려야하는 adapter갱신
                refreshAdapter()
            }
        }
    }

    fun refreshAdapter() {
        memoList.clear()
        memoList.addAll(memoDAO.getAll())
        memoAdapter.notifyDataSetChanged() //이미 위에서 어댑처 연결되어잇고 notify~하면 제일 최근 리스트로 뿌림
        binding.editMemo.setText("")
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        refresh()
//    }
//    fun refresh() {
//        for (item in 0..memoList.size+1) {
//            memoDAO.delete(memoDAO.getAll())
//        }
//
//        memoAdapter.notifyDataSetChanged()
//    }
}