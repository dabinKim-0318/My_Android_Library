package Room

import androidx.room.*

//Room은 데이터베이스에 읽고 쓰는 메서드를 인터페이스 형태로 설계하고 사용함
//->SQLiteOpenHelper를 상속받은 class 안에 CRUD수행 쿼리 전달하는 메서드 작성하는 거랑 비슷
//코드 없이 이름만 명시하는 형태로 인터페이스를 만들면 rOOM이 나머지 코드를 자동생성함
//DAO:Data Access Object  데이터베이스에 접근해서 DML쿼리(CRUD수행하는 쿼리)를 실행하는 메서드의 모음
@Dao //DAO라는 것을 명시
interface RoomMemoDAO {

    @Query("select * from room_memo") //조회하는 ORM은 select쿼리로 직접 지정 가능
    fun getAll(): List<RoomMemo>  //데이터 조회->테이블 리스트 리턴함

    @Insert(onConflict = OnConflictStrategy.REPLACE) //기존에 저장되있던 Primary key의 데이터가 업데이트되면 insert안하고 걍 업데이트 해줌
    fun insert(memo: RoomMemo)

    @Delete
    fun delete(memo: RoomMemo)

}