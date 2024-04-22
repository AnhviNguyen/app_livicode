package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsprojectpractice.databinding.FragmentLessonFrameBinding

class LessonAdapter (
    private val images: List<Int>,
    private val lesson_names: List<String>,
    private val processBarIndex: MutableList<Int>,
    private val listener: OnItemClickListener,
):RecyclerView.Adapter<LessonAdapter.LessonViewHolder>(){

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
    class LessonViewHolder (private val binding: FragmentLessonFrameBinding, private val listener: OnItemClickListener): RecyclerView.ViewHolder(binding.root){

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(position)
                }
            }
        }
        fun bind(image: Int, lessonName: String, index: Int) {
            binding.lessonImage.setImageResource(image)
            binding.lessonName.text = lessonName
            binding.lessonProgressBar.max =100
            binding.lessonProgressBar.progress = index
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        val binding =  FragmentLessonFrameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LessonViewHolder(binding, listener)
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