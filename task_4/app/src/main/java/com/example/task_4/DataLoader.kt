package com.example.task_4

import android.util.Log.d
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


object DataLoader {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://reqres.in/api/")
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()

    var service = retrofit.create<ApiRetrofit>(ApiRetrofit::class.java)

    fun getRequest(path: String){
        var call= service.getRequest(path)
        call.enqueue(callback)

    }
//    fun postRequest(path: String,parameters: MutableMap<String,String>){
//    val parameters = mutableMapOf<String,String>()
//        val call= service.postRequest(path, parameters)
//        call.enqueue(callback)
//    }
    private val callback = object :Callback<String> {
        override fun onFailure(call: Call<String>, t: Throwable) {
            d("getRequest", "${t.message}")
        }

        override fun onResponse(call: Call<String>, response: Response<String>) {
            d("getRequest", "${response.body()}")
        }
    }

}


interface ApiRetrofit {
    @GET("{path}")
    fun getRequest(@Path("path") path: String): Call<String>
//    @FormUrlEncoded
//    @POST("{path}")
//    fun postRequest(@Path("path") path: String,parameters:Map<String,String>): Call<String>
}