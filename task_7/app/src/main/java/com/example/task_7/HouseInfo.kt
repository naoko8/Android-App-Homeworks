package com.example.task_7

import com.google.gson.annotations.SerializedName

data class HouseInfo(@SerializedName("descriptionEN")
                        val description: String, @SerializedName("titleEN")
                        val title: String,val img: String) {

}