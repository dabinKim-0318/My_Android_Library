package MVVM

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class Contact(

    @PrimaryKey(autoGenerate = true)
    var id: Long?,

    @ColumnInfo
    var name: String,

    @ColumnInfo
    var number: String,

    @ColumnInfo
    var initial: Char
) {
    constructor() : this(null, "", "", '\u0000')
}