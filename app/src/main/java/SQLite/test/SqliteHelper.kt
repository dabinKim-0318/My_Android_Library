package SQLite.test

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//sqlite를 사용하는 도구가 되는 클래스를 안드로이드에서 제공하는데 그거 이름이 SQLiteOpenHelper
//데이터 베이스도 안드로이드 입장에서 하나의 파일이 생성되는거기 때문에 파일의 이름=name을 지정해줘야함
class SqliteHelper(context: Context, name: String, version: Int) :
    SQLiteOpenHelper(context, name, null, version) {
    //name에 해당하는 파일이 내부저장소에 생성되는데 name에 해당하는 파일이 생성되어잇지 않으면=내가 지정 안하면
    //onCreate가 자동호출되어서 파일을 만듦
    //onCreate가 안드로이드에서 호출될때 내가 사용할 수 있는 데베 도구도 db라는 파라미터로 전달됨
    //데베가 생성되어있지 않으면 onCreate가 자동 호출되어 메서드에서 테이블을 생성
    //데베가 생성되어 있으면 더 이상 실행되지 않음
    override fun onCreate(db: SQLiteDatabase?) {
        //데이터베이스 타입 종류는 integer/text/real
        //integer타입으로, primary key로 해두면 no레코드 추가될때마다 숫자 자동증가
        //sql예약어를 사용하기 위해서 ``로 감쌈
        //쿼리 작성시 컬럼,데이블명 모두 소/대문자 일관되게만 하면 작성 규칙 상관없음
        val create = "create table memo (`no` integer primary key, content text, datetime integer)"
        db?.execSQL(create)
    }

    //SqliteHelper에 전달되는 버전 정보가 변경되었을때 현재 생성되어 있는 데이터베이스의 버전과 비교해서 더 높으면 호출됨. 버전변경사항 없으면 호출 안됨
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

    //데이터 입력함수: SqliteHelper에 이렇게 만들어두어도 되지만 메모장에 '데이터'를 넣는 행위니까 data class로 따로 빼서 만들자
    //fun insertMeno(content: String, datetime: Long) {}
    fun insertMemo(memo: Memo) {
        val values = ContentValues()
        //values.put("no", memo.no)  no는 null을 허용했고 프라이머리키라 저절로 증가
        values.put("content", memo.content)
        values.put("datetime", memo.datetime)
        //쓰기전용 데베 얻어옴
        val wd = writableDatabase
        wd.insert("memo", null, values)
        wd.close()
    }

    fun selectMemo(): MutableList<Memo> {
        val list = mutableListOf<Memo>()
        //memo테이블 전체 데이터 조회
        val select = "select * from memo"
        //읽기전용 데베 얻어옴
        val rd = readableDatabase
        val cursor: Cursor = rd.rawQuery(select, null)
        //moveToNext:다음 줄에 사용할 수 있는 레코드가 있는지 여부 반환 후 커서를 다음위치로 이동
        //레코드가 없으면 반복문 빠져나가고 모든 레코드 읽을때까지 반복
        while (cursor.moveToNext()) {
            // 먼저 컬럼의 이름으로 각각의 위치를 가져온다.
            val noIdx = cursor.getColumnIndex("no") // 1 : 테이블에서 no 컬럼의 순서 조회
            val contentIdx = cursor.getColumnIndex("content") // 2
            val dateIdx = cursor.getColumnIndex("datetime") // 3

            val no = cursor.getLong(noIdx) // 값은 위에서 저장해 둔 컬럼의 위치로 데이터 가져올때 타입일치!
            val content = cursor.getString(contentIdx)
            val datetime = cursor.getLong(dateIdx)
           //리턴할 list에 가져온 데이터들 담음
            list.add(Memo(no, content, datetime))
        }

        cursor.close()  //리턴전 커서와 데베 close해줘야함 메모리 릭 날수도 있음
        rd.close()
        return list
    }

    fun updateMemo(memo: Memo) {
        val values = ContentValues()
        values.put("content", memo.content)
        values.put("datetime", memo.datetime)

        val wd = writableDatabase
        //update(테이블명,수정할값,수정할조건)
        //수정할 조건은 PRIMARY KEY로 지정된 컬럼을 사용하며 여기선 PRIMARY KEY인 컬럼이 no라서 ㅜㅐ=tntwk
        wd.update("memo", values, "no = ${memo.no}", null)
        wd.close()
    }

    fun deleteMemo(memo: Memo) {
        val db = writableDatabase
        val delete = "delete from memo where no = ${memo.no}"
        db.execSQL(delete)
        //위에 두줄 한줄로 가능->   db.delete("memo", "no=${memo.no}", null)
        db.close()
    }
}


//no,datetime의 타입 데베에선 integer라고 했는데 여기서 long인 이유:숫자의 범위가 서로 다름
//sqlite에서 integer로 선언한거 소스코드에서long으로 선언이 일반적
//no만 null을 허용한 이유:PRIMARY-KEY로 no는 자동으로 증가되는 옵션 줬기때문에 데이터 삽입시 필요하지 않음
data class Memo(var no: Long?, var content: String, var datetime: Long)