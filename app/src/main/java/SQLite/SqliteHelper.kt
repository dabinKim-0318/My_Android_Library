package SQLite

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//sqlite를 사용하는 도구가 되는 클래스를 안드로이드에서 제공하는데 그거 이름이 sqliteopenhelper이기때문
//데이터 베이스도 안드로이드 입장에서 하나의 파일이 생성되는거기 때문에 파일의 이름=name을 지정해줘야함
class SqliteHelper(context: Context, name: String, version: Int) : SQLiteOpenHelper(context, name, null, version) {
    //name에 해당하는 파일이 내부저장소에 생성되는데 name에 해당하는 파일이 생성되어잇지 않으면=내가 지정 안하면
    //onCreate가 자동호출되어서 파일을 만듦
    //onCreate가 안드로이드에서 호출될때 내가 사용할 수 있는 데베 도구도 db라는 파라미터로 전달됨
    override fun onCreate(db: SQLiteDatabase?) {
        //데베에 memo라는 이름의 테이블을 만들고 no라는 속성값은 integer타입으로, primary key로 해두면 1,2,3,4,...정수값 자동 입력되어서 생성됨
        //sql예약어를 사용하기 위해서 ``로 감쌈
        //    val create = "create table memo (`no` integer primary key, content text, datetime integer)"
        val create = "create table memo (`no` integer , content text, datetime integer)"
        db?.execSQL(create)
    }

    //생성되어있는데 버전이 다르면 onUpgrade가 호출?
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        //테이블의 변경사항이 있을 경우 호출됨
        //SqliteHelper()의 생성자를 호출할떄 기존 데베와 version을 비교해서 높으면 호출됨
    }

    //데이터 입력함수: SqliteHelper에 이렇게 만들어두어도 되지만 메모장에 '데이터'를 넣는 행위니까 data class로 따로 빼서 만들자
    //fun insertMeno(content: String, datetime: Long) {}
    fun insertMemo(memo: Memo) {
        //contentValues라는 형태로 데이터베이스에 던져주기만하면 알아서 들어감 SQLiteOpenHelper를 상송받았기에 가능
        //writableDatabase로 디비 가져올 수 있음
        //1.db가져오기
        val wd = writableDatabase
        val values = ContentValues()
        values.put("content", memo.content) //key-value값으로 넣어줌
        values.put("datetime", memo.datetime)
        //2.db에 넣기 wd.insert(테이블이름, null, 값)
        wd.insert("memo", null, values)
        //3.db 닫기
        wd.close()
    }

    //데이터 조회함수


    @SuppressLint("Range")
    fun selectMemo(): MutableList<Memo> {
        val list = mutableListOf<Memo>()

        val select = "select * from memo" //"select no, content, datetime from memo"
        val rd = readableDatabase
        val cursor = rd.rawQuery(select, null)  //앞선 execSQL는 리턴값이 없고 rawQuery는 명령어 실행 후 cursor 반환
        while (cursor.moveToNext()) {  //데이터 세트에서 첫번째줄을 커서가 가르키고 있는거고
            val no = cursor.getLong(cursor.getColumnIndex("no")) //첫번째줄의 값을 꺼낼수있는 상태에서 Long타입 값을 꺼낼꺼다
            val content = cursor.getString(cursor.getColumnIndex("content")) //cursor에게 속성값의 인덱스를 알려줘야함
            val datetime = cursor.getLong(cursor.getColumnIndex("datetime"))
            val memo = Memo(no, content, datetime)
            list.add(memo)
        }
        cursor.close() //리턴전 커F서와 데베 close해줘야함 메모리 릭 날수도 있음
        rd.close()
        return list
    }

    //데이터 수정: 데이터 수정도 key-value로 변환해서 해줘야함
    fun updateMemo(memo: Memo) {
        val wd = writableDatabase
        val values = ContentValues()
        values.put("content", memo.content)
        values.put("datetime", memo.datetime)
        //memo테이블에 values넣을건데 primary키인 no로 어느 인덱스 번호에 값 넣을건지 알려줘야함
        wd.update("memo", values, "no = ${memo.no}", null)
        wd.close()
    }

    //데이터 삭제: 인자값으로 long타입의 no을 줘도됨
    fun deleteMemo(memo: Memo) {
        val wd = writableDatabase
        val delete = "delete from memo where no = ${memo.no}" //memo테이블에서 no가 memo.no와 같은 데이터를 지워라
        wd.execSQL(delete)
        //위에 두줄 한줄로 가능->   wd.delete("memo", "no=${memo.no}", null)
        wd.close()

    }
}


data class Memo(var no: Long?, var content: String, var datetime: Long)


//class SQLiteActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityMain3Binding
//
//    companion object {
//        const val DB_NAME = "sqlite.sql"
//        const val DB_VERSION = 1
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMain3Binding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        //SqliteHelper 객체 생성후 호출되면 DB_NAME에 해당하는 거 뒤지고 없으면 DB_NAME 파일 생성함과 동시에 meno라는 테이블도 같이 생성됨
//        val helper = SqliteHelper(this, DB_NAME, DB_VERSION)
//        val meno: Memo = Memo(1, "내용", 123456)
//        helper.insertMemo(meno)
//    }
//}
//
