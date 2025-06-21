package com.example.mobilequizapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mobilequizapp.data.SampleQuestions

class QuizViewModelFactory(
    private val category: String
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuizViewModel::class.java)) {
            val questions = when (category) {
                "OS" -> SampleQuestions.osSingle + SampleQuestions.osMulti
                "DB" -> SampleQuestions.dbSingle + SampleQuestions.dbMulti
                else -> SampleQuestions.osSingle + SampleQuestions.osMulti
            }
            @Suppress("UNCHECKED_CAST")
            return QuizViewModel(questions) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

