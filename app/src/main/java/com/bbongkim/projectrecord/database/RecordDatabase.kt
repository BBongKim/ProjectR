package com.bbongkim.projectrecord.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [RecordEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class RecordDatabase : RoomDatabase() {
    abstract fun recordDao(): RecordDao

    companion object {
        private var instance: RecordDatabase? = null

        @Synchronized
        fun getInstance(context: Context): RecordDatabase {
            if (instance == null) {
                synchronized(this) {
                    instance =
                        Room.databaseBuilder(context, RecordDatabase::class.java, "database-record")
                            .build()
                }
            }
            return instance!!
        }
    }
}