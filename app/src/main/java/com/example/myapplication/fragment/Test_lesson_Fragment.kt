package com.example.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapters.TestAdapter
import com.example.newsprojectpractice.R
import com.example.newsprojectpractice.databinding.ActivityLessonBinding
import com.example.newsprojectpractice.databinding.FragmentTestLessonBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Test_lesson_Fragment : Fragment() {

    private val binding: FragmentTestLessonBinding by lazy {
        FragmentTestLessonBinding.inflate(layoutInflater)
    }
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Test_lesson_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val images = listOf(R.drawable.quiz3, R.drawable.quiz2, R.drawable.quiz5)
        val orderNumbers = listOf("Quiz 1","Quiz 2", "Quiz 3")
        val namesQuiz = listOf("Name of quiz 1", "Name of quiz 2", "Name of quiz 3")

        val adapter = TestAdapter(images, orderNumbers, namesQuiz)
        binding.quizRecycleView.layoutManager = LinearLayoutManager(context)
        binding.quizRecycleView.adapter = adapter
    }

}