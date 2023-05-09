package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.UserAdapter
import com.example.myapplication.api.AppInterface
import com.example.myapplication.data_class.UsersItem
import kotlinx.android.synthetic.main.activity_coffee_users.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder
import kotlinx.android.synthetic.main.activity_main.*


const val BASE_URL = "https://jsonplaceholder.typicode.com/"
class CoffeeUsers : AppCompatActivity() {

    lateinit var userAdapter : UserAdapter
    lateinit var linearLayoutManager : LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coffee_users)

        //Animation
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        linearLayoutManager = LinearLayoutManager(this)
        rv1.setHasFixedSize(true)
        rv1.layoutManager = linearLayoutManager


        getUsers()
    }

    private fun getUsers() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(AppInterface::class.java)

        val retrofitData = retrofitBuilder.retrieveUsers()
        retrofitData.enqueue(object : Callback<List<UsersItem>?> {
            override fun onResponse(
                call: Call<List<UsersItem>?>,
                response: Response<List<UsersItem>?>
            ) {
                val responseBody = response.body()!!

                userAdapter = UserAdapter(baseContext, responseBody)
                userAdapter.notifyDataSetChanged()
                rv1.adapter = userAdapter

                userAdapter.onItemCLick = {
                    val i = Intent(this@CoffeeUsers, UserProfile::class.java)
                    i.putExtra("key", it)
                    startActivity(i)
                }


            }

            override fun onFailure(call: Call<List<UsersItem>?>, t: Throwable) {
                
            }
        })
    }
}