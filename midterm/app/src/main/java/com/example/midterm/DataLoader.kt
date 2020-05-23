package com.example.midterm

import android.util.Log.d
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


object DataLoader {
    private val client = OkHttpClient.Builder().build()

    var retrofit = Retrofit.Builder()
        .baseUrl("https://simplifiedcoding.net/demos/marvel/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun<T> buildService(service:Class<T>):T{
        return retrofit.create(service)
    }
    var service = retrofit.create<ApiRetrofit>(ApiRetrofit::class.java)

    fun getRequest(path: String){
        val call= service.getRequest(path)
        call.enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                d("getRequest", "${t.message}")
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                d("getRequest", "${response.body()}")
            }

        })
    }
}
interface ApiRetrofit {
    @GET("{path}")
    fun getRequest(@Path("path") path: String): Call<String>
}


