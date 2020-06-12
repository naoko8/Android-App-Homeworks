package com.example.task_7

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recycler_view_layout.view.*

object DataBinding {
    @JvmStatic
    @BindingAdapter("source")
    fun setImage(imageView: ImageView, image: String) {
        Glide.with(imageView.context)
            .load(image)
            .into(imageView.coverImageView)
    }
}
