package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapters.CourseHomeAdapter
import com.example.myapplication.adapters.LessonAdapter
import com.example.newsprojectpractice.R
import com.example.newsprojectpractice.databinding.ActivityChooseLessonCourseBinding

class choose_lesson_course : AppCompatActivity() {
    private val binding: ActivityChooseLessonCourseBinding by lazy {
        ActivityChooseLessonCourseBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val images = listOf(R.drawable.user10, R.drawable.user7,  R.drawable.user6)
        val title = listOf("Lesson 1", "Lesson 2", "Lesson 3")
        val processbar = mutableListOf(20, 40, 60)
        val adapter = LessonAdapter(images, title, processbar)
        binding.LessonRecycleView.layoutManager = LinearLayoutManager(this)
        binding.LessonRecycleView.adapter = adapter
    }
}