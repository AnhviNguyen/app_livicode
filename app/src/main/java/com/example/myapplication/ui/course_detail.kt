package com.example.myapplication.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ExpandableListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.newsprojectpractice.R
import CourseApdater
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.data.Expandable_data_course.data
import com.example.newsprojectpractice.databinding.ActivityCourseDetailBinding
import com.example.newsprojectpractice.databinding.ActivityHomeBinding


class course_detail : AppCompatActivity() {
    private val binding: ActivityCourseDetailBinding by lazy {
        ActivityCourseDetailBinding.inflate(layoutInflater)
    }

    lateinit var expandableListView: ExpandableListView
    lateinit var expandableListAdapter: CourseApdater
    lateinit var expandableListTitle:List<String>
    var expandabalListDetail: HashMap<String, List<String>> = HashMap()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        expandableListView = binding.expandableListView

        expandabalListDetail = data
        expandableListTitle  = ArrayList<String> (expandabalListDetail.keys)

        expandableListAdapter = CourseApdater(this, expandableListTitle, expandabalListDetail)
        expandableListView.setAdapter(expandableListAdapter)


        expandableListView.setOnGroupExpandListener {
            groupPosition ->
            Toast.makeText(
                this,
                expandableListTitle[groupPosition] + "List Expanded",
                Toast.LENGTH_SHORT
            ).show()
            setDynamicHeight(expandableListView)
        }
        expandableListView.setOnGroupCollapseListener {  groupPosition ->
            Toast.makeText(
                this,
                expandableListTitle[groupPosition] + "List Collapsed",
                Toast.LENGTH_SHORT
            ).show()
            setDynamicHeight(expandableListView)
        }
        expandableListView.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            Toast.makeText(
                this,
                expandableListTitle[groupPosition] + "->" + expandabalListDetail[expandableListTitle[groupPosition]]!![childPosition],
                Toast.LENGTH_SHORT
            ).show()
            false
        }

        binding.enterCourse.setOnClickListener{
            val intent = Intent(this, choose_lesson_course::class.java)
            startActivity(intent)
        }

        binding.courseDetailBackBtn.setOnClickListener {
            onBackPressed()
        }
    }

    fun setDynamicHeight(mExpandableListView: ExpandableListView) {
        val listAdapter = mExpandableListView.expandableListAdapter
        var totalHeight = 0
        val desiredWidth = View.MeasureSpec.makeMeasureSpec(mExpandableListView.width, View.MeasureSpec.EXACTLY)
        for (i in 0 until listAdapter.groupCount) {
            val groupItem = listAdapter.getGroupView(i, false, null, mExpandableListView)
            groupItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED)
            totalHeight += groupItem.measuredHeight
            if (mExpandableListView.isGroupExpanded(i)) {
                for (j in 0 until listAdapter.getChildrenCount(i)) {
                    val listItem = listAdapter.getChildView(i, j, false, null, mExpandableListView)
                    listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED)
                    totalHeight += listItem.measuredHeight
                }
            }
        }
        val params = mExpandableListView.layoutParams
        params.height = totalHeight
        mExpandableListView.layoutParams = params
        mExpandableListView.requestLayout()
    }
}