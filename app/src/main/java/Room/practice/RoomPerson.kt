package Room.practice

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_person")
class RoomPerson {
    @ColumnInfo
    var name: String = ""

    @PrimaryKey
    @ColumnInfo
    var phone: String=""

    @ColumnInfo
    var address: String = ""

    constructor(name: String, phone: String, address: String) {
        this.name = name
        this.phone = phone
        this.address = address
    }
}