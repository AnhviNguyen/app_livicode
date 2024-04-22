package com.example.myapplication.ui

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.fragment.test_frame
import com.example.newsprojectpractice.R
import com.example.newsprojectpractice.databinding.ActivityLessonBinding
import com.example.newsprojectpractice.databinding.ActivityQuizBinding

class quiz : AppCompatActivity() {

    private val binding: ActivityQuizBinding by lazy{
        ActivityQuizBinding.inflate(layoutInflater)
    }

    private val questions = arrayOf("What is the built-in databse in Android Studio?",
        "What is the full form of APK in Android Developer?",
        "In which year, first android was released by Google?")

    private val options = arrayOf(arrayOf("My SQL", "SQLite", "Firebase", "SQL Server"),
        arrayOf("Application Programing Interface", "Android Programing Interface", "Android Package Information", "Application Package Information"),
        arrayOf("2010", "2006", "2008", "2012")
    )

    private val correctAnswers = arrayOf(1,0,2)

    private var currentQuestionIndex =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        displayQuestion()
        resetButton()

        binding.option1.setOnClickListener{checkAnswer(0)}
        binding.option2.setOnClickListener{checkAnswer(1)}
        binding.option3.setOnClickListener{checkAnswer(2)}
        binding.option4.setOnClickListener{checkAnswer(3)}
        binding.nextQuiz.setOnClickListener{
            nextQuestion()
        }
    }

    private fun resetButton(){
        binding.option1.setTextColor(Color.BLACK)
        binding.option2.setTextColor(Color.BLACK)
        binding.option3.setTextColor(Color.BLACK)
        binding.option4.setTextColor(Color.BLACK)
    }


    private fun correctButtonColors (buttonIndex: Int){
        when(buttonIndex){
            0-> binding.option1.setTextColor(Color.GREEN)
            1-> binding.option2.setTextColor(Color.GREEN)
            2-> binding.option3.setTextColor(Color.GREEN)
            3-> binding.option4.setTextColor(Color.GREEN)
        }
    }

    private  fun wrongButtonCorlor(buttonIndex: Int) {
        when (buttonIndex) {
            0 -> binding.option1.setTextColor(Color.RED)
            1 -> binding.option2.setTextColor(Color.RED)
            2 -> binding.option3.setTextColor(Color.RED)
            3 -> binding.option4.setTextColor(Color.RED)
        }
    }

    private fun displayQuestion(){
        binding.questionText.text = questions[currentQuestionIndex]
        binding.option1.text = options[currentQuestionIndex][0]
        binding.option2.text = options[currentQuestionIndex][1]
        binding.option3.text = options[currentQuestionIndex][2]
        binding.option4.text = options[currentQuestionIndex][3]
    }

    private fun checkAnswer(selectAnswerIndex: Int) {
        val correctAnswerIndex = correctAnswers[currentQuestionIndex]

        if (selectAnswerIndex == correctAnswerIndex)
            correctButtonColors(selectAnswerIndex)
        else {
            wrongButtonCorlor(selectAnswerIndex)
            correctButtonColors(correctAnswerIndex)
        }
    }

    private fun nextQuestion(){
        if (currentQuestionIndex < questions.size -1){
            currentQuestionIndex++
            resetButton()
            binding.questionText.postDelayed({displayQuestion()}, 100)
        }
        else {
            binding.nextQuiz.text = "Submit"
            val intent = Intent(this, complete_quiz::class.java)
            startActivity(intent)

        }
    }

//    override fun switchToQuizActivity() {
//        val intent = Intent(this, quiz::class.java)
//        startActivity(intent)
//    }


}