package com.example.task_4

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_recyclerview_layout.view.*

class RecyclerViewAdapter(val context:Context) :RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    var dataBaseList : List<Info> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return 5;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.myEmail.text = dataBaseList.get(position).email
        holder.myName.text = dataBaseList.get(position).name
        holder.mySurname.text= dataBaseList.get(position).lastname
        Glide.with(context).load(dataBaseList.get(position).image).apply(RequestOptions().centerCrop()).into(holder.myImage)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val myEmail : TextView = itemView!!.findViewById(R.id.emailTextView)
        val myName :TextView = itemView!!.findViewById(R.id.firstNameTextView)
        val mySurname :TextView = itemView!!.findViewById(R.id.lastNameTextView)
        val myImage :ImageView = itemView!!.findViewById(R.id.imageView)
    }


}