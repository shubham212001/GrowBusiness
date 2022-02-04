package com.sharma.growbusiness

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(sales_entity::class,item::class,purchase_entity::class,puchase_item_entity::class), version = 1, exportSchema = false)
abstract class task_database : RoomDatabase() {
    abstract fun todoDao(): dao


    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: task_database? = null

        fun getDatabase(context: Context): task_database {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    task_database::class.java,
                    "Database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}