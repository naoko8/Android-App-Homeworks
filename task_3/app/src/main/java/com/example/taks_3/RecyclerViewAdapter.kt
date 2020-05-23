package com.example.taks_3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.Viewholder>(){
    inner class Viewholder(itemView:View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        return Viewholder(LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview_layout,parent,false))
    }

    override fun getItemCount(): Int {
       return 5;
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        TODO("Not yet implemented")
    }
}
