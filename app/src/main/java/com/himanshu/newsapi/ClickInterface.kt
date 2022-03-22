package com.himanshu.newsapi

import com.himanshu.newsapi.apimodels.Articles
import com.himanshu.newsapi.database.News

interface ClickInterface {
    fun onClick(articles: Any)
}