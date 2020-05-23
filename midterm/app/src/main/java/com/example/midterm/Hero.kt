package com.example.midterm

import android.os.Parcel
import android.os.Parcelable

class Hero (var name: String,var realName: String, var team:String, var firstappearance:String, var createdBy: String,var publisher :String, var imageUrl:String, var bio :String) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(realName)
        parcel.writeString(team)
        parcel.writeString(firstappearance)
        parcel.writeString(createdBy)
        parcel.writeString(publisher)
        parcel.writeString(imageUrl)
        parcel.writeString(bio)
    }
    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Hero> {
        override fun createFromParcel(parcel: Parcel): Hero {
            return Hero(parcel)
        }

        override fun newArray(size: Int): Array<Hero?> {
            return arrayOfNulls(size)
        }
    }




}