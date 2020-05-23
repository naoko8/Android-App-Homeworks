package com.example.midterm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movieslayout.view.*



    class RecyclerViewAdapter(private val items: ArrayList<Hero>, private val activity: MovieListActivity) :

        RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private lateinit var model: Hero
            fun onBind() {
                model = items[adapterPosition]
                itemView.name.text = itemView.name.text.toString().replace("{title}", model.name)
                itemView.realName.text = itemView.realName.text.toString().replace("{title}", model.realName)
                itemView.team.text = itemView.team.text.toString().replace("{title}", model.team)
                itemView.firstAppearance.text = itemView.firstAppearance.text.toString().replace("{title}", model.firstappearance)
                itemView.createdBy.text = itemView.createdBy.text.toString().replace("{title}", model.createdBy)
                itemView.publisher.text = itemView.publisher.text.toString().replace("{title}", model.publisher)
                Glide.with(itemView.context).load("https://simplifiedcoding.net/demos/marvel/${model.imageUrl}").into(itemView.imageView)
                itemView.bio.text = itemView.bio.text.toString().replace("{title}", model.bio)


                itemView.setOnLongClickListener {
                    activity.items.removeAt(adapterPosition)
                    notifyItemRemoved(adapterPosition)
                    true
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.movieslayout,
                parent,
                false
            )
        )


        override fun getItemCount() = 5

        override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind()
    }
