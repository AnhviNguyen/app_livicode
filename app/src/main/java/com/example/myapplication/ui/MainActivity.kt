package com.example.myapplication.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapters.CategoriesHomeAdapter
import com.example.myapplication.adapters.CourseHomeAdapter
import com.example.newsprojectpractice.R
import com.example.newsprojectpractice.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView;


class MainActivity : AppCompatActivity(), CourseHomeAdapter.OnItemClickListener {

    private val binding: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.selectedItemId = R.id.bottom_home

        bottomNavigationView.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.bottom_home -> return@setOnItemSelectedListener true
                R.id.bottom_courses -> {
                    startActivity(Intent(applicationContext, courses::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    finish()
                    return@setOnItemSelectedListener true
                }

                R.id.bottom_setting -> {
                    startActivity(Intent(applicationContext, setting::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    finish()
                    return@setOnItemSelectedListener true
                }

                R.id.bottom_search -> {
                    startActivity(Intent(applicationContext, search::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    finish()
                    return@setOnItemSelectedListener true
                }

                R.id.bottom_profile -> {
                    startActivity(Intent(applicationContext, profile::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    finish()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }

        val course_home_images = listOf(R.drawable.user9, R.drawable.user8, R.drawable.user7, R.drawable.user6)
        val course_home_durations = listOf("3h 15mins", "2h 15mins", "1h 45mins", "2h 30mins")
        val course_home_title = listOf("React", "Kotlin", "Laravel", "Java")
        val course_home_title_detail = listOf("Advanced of web application", "Advanced of app application", "Advanced of web application", "Advanced of web application")
        val adapter = CourseHomeAdapter(course_home_images, course_home_durations, course_home_title, course_home_title_detail, this)
        binding.courseHomeRecyleView.layoutManager = LinearLayoutManager(this)
        binding.courseHomeRecyleView.adapter = adapter

        val catagories = listOf("#Back-end", "#Front-end")
        val adapter_cate = CategoriesHomeAdapter(catagories)
        binding.categoriesHomeRecycleView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.categoriesHomeRecycleView.adapter = adapter_cate

        binding.courseHomeRecyleView.setOnClickListener{
            val intent = Intent(this, course_detail::class.java)
            startActivity(intent)
        }


    }

    override fun onItemClick(position: Int) {
         val intent = Intent(this, course_detail::class.java)
         startActivity(intent)
    }
}