package com.himanshu.newsapi

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.himanshu.newsapi.adapters.MyAdapter
import com.himanshu.newsapi.apimodels.DataItem
import com.himanshu.newsapi.database.NewsDatabase
import com.himanshu.newsapi.fragments.HomeFragment

class ActivityViewModel(context: Context, private val repository: HomeFragment) : ViewModel(){
    val apiClient = ApiClient.create()

    val myAdapter = MyAdapter(context)


}