package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myapplication.data_class.UsersItem

class UserProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        //Animation
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        val userKey = intent.getParcelableExtra<UsersItem>("key")
        if(userKey != null){
            val textView : TextView = findViewById(R.id.tv_userProfileName)
            val textView1 : TextView = findViewById(R.id.tv_userProfileAge)
            val textView2 : TextView = findViewById(R.id.tv_userProfileEmail)
            val textView3 : TextView = findViewById(R.id.tv_userProfileWebsite)


            textView.text = userKey.name
            textView1.text = userKey.phone
            textView2.text = userKey.email
            textView3.text = userKey.website
        }


    }
}