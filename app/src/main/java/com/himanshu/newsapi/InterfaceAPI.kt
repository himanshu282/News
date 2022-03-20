package com.himanshu.newsapi

import com.himanshu.newsapi.apimodels.DataItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface InterfaceAPI {
    @GET("/v2/everything?q=tesla&from=2022-02-16&sortBy=publishedAt&apiKey=b456fac9a7a745039e92cdb4e437de2f")
    fun getData() : Call<DataItem>
}