package com.example.task_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init();
        getUsers();
    }

    private fun init(){
        recyclerView = findViewById(R.id.recyclerView)
        recyclerAdapter = RecyclerViewAdapter(this)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=recyclerAdapter
        val myInterface = DataLoader.getRequest("path")
       // myInterface.
    }
    private fun getUsers(){
        DataLoader.getRequest("users")
    }

}
