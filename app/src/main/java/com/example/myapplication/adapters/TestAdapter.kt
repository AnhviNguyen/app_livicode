package com.example.myapplication.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ui.quiz
import com.example.newsprojectpractice.R
import com.example.newsprojectpractice.databinding.FragmentTestFrameBinding

class TestAdapter(
    private val images :List<Int>,
    private val order_numbers: List<String>,
    private val name_quizs :List<String>,
):RecyclerView.Adapter<TestAdapter.TestViewHolder>() {
    class TestViewHolder (private val binding: FragmentTestFrameBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(image: Int, orderNumber: String, nameQuiz: String) {
            binding.quizRepresentaionImage.setImageResource(image)
            binding.orderNumber.text = orderNumber
            binding.nameQuiz.text = nameQuiz
        }

        fun setupQuizStartButton() {
            binding.root.findViewById<Button>(R.id.quiz_start).setOnClickListener {
                Log.d("Button Click", "Button start_quiz clicked!")
                val intent = Intent(binding.root.context, quiz::class.java)
                binding.root.context.startActivity(intent)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        return TestViewHolder(FragmentTestFrameBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return order_numbers.size
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        val image = images[position]
        val order_number = order_numbers[position]
        val name_quiz = name_quizs[position]

        holder.bind(image, order_number, name_quiz)
        holder.setupQuizStartButton()

    }
}