package com.example.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsprojectpractice.R
import com.example.newsprojectpractice.databinding.ActivitySignUpBinding
import com.example.newsprojectpractice.databinding.ActivityStartBinding

class sign_up : AppCompatActivity() {
    private val binding: ActivitySignUpBinding by lazy{
        ActivitySignUpBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.loginLink.setOnClickListener{
            val intent = Intent(this, log_in::class.java)
            startActivity(intent)
        }
    }
}