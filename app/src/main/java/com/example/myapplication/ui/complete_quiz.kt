package com.example.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsprojectpractice.R
import com.example.newsprojectpractice.databinding.ActivityCompleteQuizBinding

class complete_quiz : AppCompatActivity() {
    private val binding: ActivityCompleteQuizBinding by lazy{
        ActivityCompleteQuizBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.nextCompleteQuiz.setOnClickListener(){
            val intent = Intent(this, choose_lesson_course::class.java)
            startActivity(intent)
        }

    }
}