package com.example.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.newsprojectpractice.R

class intro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, start::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}