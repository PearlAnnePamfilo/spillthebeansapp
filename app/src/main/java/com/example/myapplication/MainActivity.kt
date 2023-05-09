package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Animation
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        feedButton.setOnClickListener {
            val i = Intent(this, CoffeeUsers::class.java)
            startActivity(i)
        }

        faqsButton.setOnClickListener {
            val i = Intent(this, AboutUs::class.java)
            startActivity(i)
        }

        exitButton.setOnClickListener {
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            this.finish()
        }



    }








}