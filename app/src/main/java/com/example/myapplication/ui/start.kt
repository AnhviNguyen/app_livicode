package com.example.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.newsprojectpractice.R
import com.example.newsprojectpractice.databinding.ActivityStartBinding

class start : AppCompatActivity() {

    private val binding: ActivityStartBinding by lazy{
        ActivityStartBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.nextStart.setOnClickListener{
            val intent = Intent(this, log_in::class.java)
            startActivity(intent)
        }
    }
}