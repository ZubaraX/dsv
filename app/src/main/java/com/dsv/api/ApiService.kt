package com.dsv.api

import com.dsv.model.YourDataModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("your_endpoint")
    fun getData(): Call<YourDataModel>
}