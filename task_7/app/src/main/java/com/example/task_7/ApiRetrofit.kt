package com.example.task_7

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRetrofit {
    @GET("{path}")
    fun getRequest(@Path("path") path: String): Call<String>
}