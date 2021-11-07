package Room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Room을 사용하기 위해서는 data class로 만들었던 값들을 Room class로 만들어서 하나의 테이블 역할을 하게함

//클래스 하나는 테이블 변수 하나는 속성=컬럼이다
@Entity(tableName = "room_memo")  //Entity 어노테이션을 활용해서 해당 테이블의 이름을 지정
class RoomMemo {
    @PrimaryKey(autoGenerate = true)  //no를 프라이머리키로 지정해서 no의 값이 없을때 자동으로 숫자 증가
    @ColumnInfo  //컬럼으로 쓰겠다는 애너테이션
    var no: Long? = null

    @ColumnInfo
    var content: String = ""

    @ColumnInfo(name = "date")  //소스코드에선 dateTime으로 쓰고 데베에 속성에는 date라는 이름으로 지정하겠다
    var dateTime: Long = 0

    //서브 생성자를 만들어준다: 나중에 RoomMemo에 데이터 넣을때
    //val memo=Memo()
    //memo.content=어쩌구 memo.dateTime=22 insert(memo)  이렇게 넣는거 귀찮아서 애초에 insert(Memo("어쩌구",22))
    constructor(content:String, dateTime:Long){
        this.content=content
        this.dateTime=dateTime
    }
}
/*
data class RoomMemo(
    var no: Long?,
    var content: String,
    var dateTime: Long
)
*/
