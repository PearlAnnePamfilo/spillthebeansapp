package com.example.myapplication.data_class

import android.os.Parcel
import android.os.Parcelable

data class UsersItem(
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(email)
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(phone)
        parcel.writeString(username)
        parcel.writeString(website)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UsersItem> {
        override fun createFromParcel(parcel: Parcel): UsersItem {
            return UsersItem(parcel)
        }

        override fun newArray(size: Int): Array<UsersItem?> {
            return arrayOfNulls(size)
        }
    }
}