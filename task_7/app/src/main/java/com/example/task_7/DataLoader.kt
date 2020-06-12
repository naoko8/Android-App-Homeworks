package com.example.task_7

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object DataLoader {
    private var retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl("http://www.mocky.io/v2/")
        .build()

    private var service = retrofit.create(ApiRetrofit::class.java)

    fun getRequest(path: String, customCallback: CallBack) {
        val call = service.getRequest(path)
        call.enqueue(callback(customCallback))
    }

    private fun callback(customCallback: CallBack) = object : Callback<String> {

        override fun onFailure(call: Call<String>, t: Throwable) {
            customCallback.onFailed(t.message.toString())
        }

        override fun onResponse(call: Call<String>, response: Response<String>) {
            customCallback.onSuccess(response.body().toString())
        }
    }
}