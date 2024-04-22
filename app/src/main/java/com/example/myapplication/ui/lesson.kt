package com.example.myapplication.ui

import PageLessonAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.adapters.TestAdapter
import com.example.newsprojectpractice.R
import com.example.newsprojectpractice.databinding.ActivityLessonBinding
import com.google.android.material.tabs.TabLayout

class lesson : AppCompatActivity() {
    private val binding: ActivityLessonBinding by lazy {
        ActivityLessonBinding.inflate(layoutInflater)
    }

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
    private lateinit var adater: PageLessonAdapter
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

        adater = PageLessonAdapter(supportFragmentManager, lifecycle)

        tabLayout.addTab(tabLayout.newTab().setText("Introduction"))
        tabLayout.addTab(tabLayout.newTab().setText("Test"))
        tabLayout.addTab(tabLayout.newTab().setText("Discuss"))

        viewPager.adapter = adater

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null)
                    viewPager.currentItem= tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })
    }
}