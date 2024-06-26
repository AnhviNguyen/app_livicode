package com.example.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.newsprojectpractice.R
import com.example.newsprojectpractice.databinding.ActivityLogInBinding
import com.example.newsprojectpractice.databinding.ActivityStartBinding

class log_in : AppCompatActivity() {

    private val binding: ActivityLogInBinding by lazy {
        ActivityLogInBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.signUp.setOnClickListener{
            val intent = Intent(this, sign_up::class.java)
            startActivity(intent)
        }
    }
}