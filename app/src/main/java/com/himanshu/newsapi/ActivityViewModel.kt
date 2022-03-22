package com.himanshu.newsapi

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

import com.himanshu.newsapi.fragments.HomeFragment
import com.himanshu.newsapi.repository.NewsRepository

class ActivityViewModel(context: Context, private val repository: HomeFragment) : ViewModel(){
    val apiClient = ApiClient.create()




}