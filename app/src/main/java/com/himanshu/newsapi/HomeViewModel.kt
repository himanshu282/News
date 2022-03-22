package com.himanshu.newsapi

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.himanshu.newsapi.database.News
import com.himanshu.newsapi.repository.NewsRepository

class HomeViewModel() : ViewModel (){
        fun insert(news: News,context: Context) {
                val repository = NewsRepository( context )
                return repository.insertNewsInDatabase(news)
        }

        fun delete(news: News,context: Context){
                val repository = NewsRepository(context)
                return repository.deleteNewsInDatabase(news)
        }

        fun getAll(context: Context):LiveData<List<News>>{
                val repository = NewsRepository(context)
                return repository.getAllData()
        }

}