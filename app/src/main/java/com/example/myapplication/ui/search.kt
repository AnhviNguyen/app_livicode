package com.example.myapplication.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapters.SearchResultAdapter
import com.example.newsprojectpractice.R
import com.example.newsprojectpractice.databinding.ActivityCoursesBinding
import com.example.newsprojectpractice.databinding.ActivitySearchBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class search : AppCompatActivity() {

    private val binding: ActivitySearchBinding by lazy {
        ActivitySearchBinding.inflate(layoutInflater)
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.selectedItemId = R.id.bottom_search

        bottomNavigationView.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.bottom_home -> {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    finish()
                    return@setOnItemSelectedListener true
                }
                R.id.bottom_courses -> {
                    startActivity(Intent(applicationContext, courses::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    finish()
                    return@setOnItemSelectedListener true
                }

                R.id.bottom_setting -> {
                    startActivity(Intent(applicationContext, search::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    finish()
                    return@setOnItemSelectedListener true
                }

                R.id.bottom_search -> return@setOnItemSelectedListener true


                R.id.bottom_profile -> {
                    startActivity(Intent(applicationContext, profile::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    finish()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }

        val search_results = listOf("Machine learning", "Project management", "Digital marketing", "Deep learning", "Data analytics", "Power bi")
        val adapter = SearchResultAdapter(search_results)
        binding.searchRecycleView.layoutManager = LinearLayoutManager(this)
        binding.searchRecycleView.adapter = adapter
    }
}