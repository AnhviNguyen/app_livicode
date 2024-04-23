package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsprojectpractice.databinding.FragmentSearchFrameBinding

class SearchResultAdapter(
    private val textResults: List<String>
):RecyclerView.Adapter<SearchResultAdapter.SearchResultViewHolder>() {
    class SearchResultViewHolder (private val binding:FragmentSearchFrameBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(textResult: String) {
            binding.textSearch.text = textResult
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchResultViewHolder {
      return SearchResultViewHolder(FragmentSearchFrameBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(
        holder:SearchResultViewHolder,
        position: Int
    ) {
        val textResult = textResults[position]
        holder.bind(textResult)
    }

    override fun getItemCount(): Int {
       return textResults.size
    }
}