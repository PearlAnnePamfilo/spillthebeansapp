package com.example.myapplication.api

import com.example.myapplication.data_class.UsersItem
import retrofit2.Call
import retrofit2.http.GET

interface AppInterface {

    @GET("users")
    fun retrieveUsers() : Call<List<UsersItem>>

}