package com.example.midterm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.movies_recycler_view_layout.*

class MovieListActivity: AppCompatActivity() {


    val items = ArrayList<Hero>()
    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movieslayout)
        init()
    }

    private fun init() {
        movieView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerViewAdapter(items, this)
        movieView.adapter = adapter
    }

}