package com.example.task_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task_7.databinding.ActivityMainBinding
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RecyclerViewAdapter
    private var homes = ArrayList<HouseInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        ) as ActivityMainBinding

        init()
    }

    private fun init() {
        setData()
    }

    private fun setData() {
        DataLoader.getRequest(
            "5edb4d643200002a005d26f0", object : CallBack {
                override fun onSuccess(response: String) {
                    val data = Gson().fromJson(response, Array<HouseInfo>::class.java).toList()
                    homes.addAll(data)
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = RecyclerViewAdapter(homes)
                    recyclerView.adapter = adapter

                }

                override fun onFailed(errorMessage: String) {
                    d("error", errorMessage)
                }

            }
        )
    }
}
