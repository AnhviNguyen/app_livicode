package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsprojectpractice.databinding.ActivityHomeBinding
import com.example.newsprojectpractice.databinding.FragmentCategoriesHomeBinding

class CategoriesHomeAdapter(
    private val categories_name: List<String>)
    : RecyclerView.Adapter<CategoriesHomeAdapter.CaregoriesHomeViewHolder>() {

    class CaregoriesHomeViewHolder(private val binding: FragmentCategoriesHomeBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(categoryName: String) {
            binding.cateBtn.text = categoryName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CaregoriesHomeViewHolder {
        return CaregoriesHomeViewHolder(FragmentCategoriesHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return categories_name.size
    }

    override fun onBindViewHolder(holder: CaregoriesHomeViewHolder, position: Int) {
        val category_name = categories_name[position]
        holder.bind(category_name)
    }
}