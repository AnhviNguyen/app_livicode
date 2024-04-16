package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsprojectpractice.databinding.FragmentCourseFrameBinding

class CourseHomeAdapter (
    private val  images: List<Int>,
    private val durations: List<String>,
    private val items: List<String>,
    private val detail_contents : List<String>,
   )
    : RecyclerView.Adapter<CourseHomeAdapter.CourseHomeViewHolder>(){
    class CourseHomeViewHolder(private val binding: FragmentCourseFrameBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(image: Int, duration: String, item: String, detailContent: String) {
            binding.courseImage.setImageResource(image)
            binding.courseDuration.text = duration
            binding.courseName.text = item
            binding.courseDetailContent.text = detailContent
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseHomeViewHolder {
        return CourseHomeViewHolder(FragmentCourseFrameBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CourseHomeViewHolder, position: Int) {
        val image = images[position]
        val duration = durations[position]
        val item = items[position]
        val detail_content = detail_contents[position]
        holder.bind(image, duration, item, detail_content)
    }

    override fun getItemCount(): Int {
        return  items.size
    }

}