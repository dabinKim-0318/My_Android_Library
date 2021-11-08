package Room.practice

import androidx.room.*

@Dao
interface RoomPhoneDAO {

    @Query("SELECT * FROM table_person ")
    fun getAll(): List<RoomPerson>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(person: RoomPerson)

    @Delete
    fun delete(person: RoomPerson)
}