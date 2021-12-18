package com.example.sopt_assignment_dabin.data.local.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [RoomLogin::class], version = 1, exportSchema = false)
abstract class RoomHelper : RoomDatabase() {
    abstract fun roomPersonDao(): RoomDAO

    companion object {
        private var instance: UserDatabase? = null

        @Synchronized
        fun getInstance(context: Context): UserDatabase? {
            if (instance == null) {
                synchronized(UserDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "user-database"
                    ).build()
                }
            }
            return instance
        }
    }