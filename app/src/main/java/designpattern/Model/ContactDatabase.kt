package designpattern.Model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object {
        private var INSTANCE: ContactDatabase? = null

        fun getInstance(context: Context): ContactDatabase? {
            if (INSTANCE == null) {
                synchronized(ContactDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java, "contact"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                   // Room.databaseBuilder 로 인스턴스를 생성하고,
                    //fallbackToDestructiveMigration 을 통해 데이터베이스가 갱신될 때 기존의 테이블을 버리고 새로 사용
                }
            }
            return INSTANCE
        }
    }

}
