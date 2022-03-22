package com.himanshu.newsapi

import com.himanshu.newsapi.apimodels.DataItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface InterfaceAPI {
    @GET("/v2/everything?q=tesla&from=2022-02-21&sortBy=publishedAt&apiKey=f089b5af76ef423bb7f287a28ea4db39")
    fun getData() : Call<DataItem>
}