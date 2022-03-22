package com.himanshu.newsapi.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(news: News)

    @Query("SELECT * FROM news_table")
    fun getAll(): LiveData<List<News>>

    @Delete
    suspend fun delete(news: News)
}