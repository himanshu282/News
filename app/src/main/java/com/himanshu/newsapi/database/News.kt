package com.himanshu.newsapi.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="news_table")
 class News(

    var title : String,
    var description: String,
    var urlToImage : String
){

    @PrimaryKey(autoGenerate = true)
     var id:Int=0
 }

