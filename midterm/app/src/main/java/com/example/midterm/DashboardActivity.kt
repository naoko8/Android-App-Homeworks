package com.example.midterm


import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity(){
    lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movieslayout)
            //init();
        }
        //listView = findViewById<ListView>(R.id.listViewHeroes)
    }

//    private fun getHeroes() {
//        val retrofit = Retrofit.Builder()
//            .baseUrl(Api.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        val api = retrofit.create(Api::class.java)

//    private fun getInfo(){
//        //listViewHeroes = DataLoader.getRequest("marvel")
//    }




