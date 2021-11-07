package Room

import androidx.room.Database
import androidx.room.RoomDatabase

//SQLiteOpenHelper를 상속받아 구현했던 것처럼 Room은 RoomDatabase를 제공함
//RoomDatabase를 상속받아 클래스를 생성함
//추상클래스로 생성해야함!!
//Database 어노테이션을 이용해서 데베라는걸 알려주고 arrayOf안에 내가 사용하는 테이블(클래스 이름)을 써줌
//테이블 여러개일수도 있어서 arrayOf로 만들거고 여러개면 , 로 구분
//version을 써주는거 중요: 처음 데베니까 1인데 앱 업데이트 되거나 하면 version변경될 수 있어서 기존에 설치된 앱의 테이블 수정하거나..

@Database(entities = arrayOf(RoomMemo::class), version = 1, exportSchema = false)
//RoomHelper는 이 데베에서 사용할 수 있는 DAO들을 꺼내서 쓸수 있게함
//지금은 테이블 하나하서 테이블 조작하는 DAO도 하나만 만들었는데 테이블 따라 DAO수도 늘어나겠지
//그 DAO들을 룸 헬퍼를 통해 꺼내서 쓴다
abstract class RoomHelper : RoomDatabase() {
    //roomMemoDao메서드의 반환값을 통해서 RoomMemoDAO의 DAO메서드들을 꺼내서 쓴다
    // roomMemoDao를 통해서 DAO메서드들을 꺼내서 쓰는거임
    // abstract으로 선언해야함 룸이 알아서 코드를 생성해준다
    abstract fun roomMemoDao(): RoomMemoDAO

}