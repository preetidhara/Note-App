package com.example.uisample.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [DailyModel::class],version = 1,exportSchema = false)
 abstract class RouTineDatabase : RoomDatabase() {                      //IMP !!!

   abstract fun dao() : Dao

    companion object {
        @Volatile
        private var INSTANCE: RouTineDatabase? = null

        fun getDatabase(context: Context): RouTineDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                   context.applicationContext,
                    RouTineDatabase::class.java,
                    "Routine_Database"
                ).build()
                INSTANCE=instance
                return instance

            }
        }
    }

}
