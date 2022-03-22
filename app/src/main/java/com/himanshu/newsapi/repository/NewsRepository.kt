package com.himanshu.newsapi.repository

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import com.himanshu.newsapi.database.News
import com.himanshu.newsapi.database.NewsDao
import com.himanshu.newsapi.database.NewsDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class NewsRepository(context:Context)
{
    private val database : NewsDatabase = NewsDatabase.getDatabase(context)
    private val newsDao : NewsDao = database.newsDao()
     fun insertNewsInDatabase(news:News){
        CoroutineScope(Dispatchers.IO).launch{
            newsDao.insert(news)
        }
    }

    fun deleteNewsInDatabase(news: News){
        CoroutineScope(Dispatchers.IO).launch {
            newsDao.delete(news)
        }
    }

    fun getAllData():LiveData<List<News>>{
           return newsDao.getAll()
    }

}


