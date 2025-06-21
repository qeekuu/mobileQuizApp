package com.example.mobilequizapp.data

data class Question(
    val id: Int,
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int? = null,
	val correctAnswerIndices: List<Int> = emptyList()
)

