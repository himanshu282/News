package com.himanshu.newsapi.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [News::class], version = 1)
abstract class NewsDatabase : RoomDatabase(){
        abstract fun newsDao() : NewsDao

        companion object {
                @Volatile
                private var INSTANCE : NewsDatabase? = null

        fun getDatabase(context: Context): NewsDatabase {
                synchronized(this){
                        if (INSTANCE == null) {
                                INSTANCE = Room.databaseBuilder(context.applicationContext, NewsDatabase::class.java, "newsDB")
                                        .build()
                }

                }
                return INSTANCE!!
        }
}


}