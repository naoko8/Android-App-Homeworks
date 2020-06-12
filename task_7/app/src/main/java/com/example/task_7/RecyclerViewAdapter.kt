package com.example.task_7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task_7.databinding.RecyclerViewLayoutBinding

class RecyclerViewAdapter (private val apartments: ArrayList<HouseInfo>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding:RecyclerViewLayoutBinding ) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind() {
            binding.home = apartments[adapterPosition]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RecyclerViewLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
    }
    override fun getItemCount(): Int = apartments.size

}