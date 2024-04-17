package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsprojectpractice.databinding.FragmentLessonFrameBinding

class LessonAdapter (
    private val images: List<Int>,
    private val lesson_names: List<String>,
    private val processBarIndex: MutableList<Int>
):RecyclerView.Adapter<LessonAdapter.LessonViewHolder>(){
    class LessonViewHolder (private val binding: FragmentLessonFrameBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(image: Int, lessonName: String, index: Int) {
            binding.lessonImage.setImageResource(image)
            binding.lessonName.text = lessonName
            binding.lessonProgressBar.max =100
            binding.lessonProgressBar.progress = index
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        return  LessonViewHolder(FragmentLessonFrameBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return lesson_names.size
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        val image = images[position]
        val lesson_name = lesson_names[position]
        val index = processBarIndex[position]
        holder.bind(image, lesson_name, index)
    }

    fun updateProgress(index: Int, newProgress: Int) {
        if (index in processBarIndex.indices) {
            processBarIndex[index] = newProgress
            notifyItemChanged(index)
        }
    }
}