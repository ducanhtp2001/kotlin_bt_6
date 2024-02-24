package com.example.demoretrofit.Network

import com.example.demoretrofit.Model.ResponseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiUser {
    @GET("/api/")
    fun getUsers(@Query ("results") resultId: Int): Call<ResponseData>
}