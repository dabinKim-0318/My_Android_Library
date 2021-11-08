package Room.practice

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = arrayOf(RoomPerson::class), version = 1, exportSchema = false)
abstract class RoomHelperPerson : RoomDatabase() {
    abstract fun roomPersonDao(): RoomPhoneDAO
}