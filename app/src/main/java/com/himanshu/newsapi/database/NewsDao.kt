package com.himanshu.newsapi.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert

import androidx.room.Query

@Dao
interface NewsDao {
    @Insert
    suspend fun insert(news: News)

    @Query("SELECT * FROM news_table")
    fun getAll(): LiveData<List<News>>

    @Delete
    suspend fun delete(news: News)
}