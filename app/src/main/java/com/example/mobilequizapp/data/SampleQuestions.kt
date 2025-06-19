package com.example.mobilequizapp.data

object SampleQuestions {
    val list: List<Question> = listOf(
        Question(
            id = 1,
            text = "Jaka jest stolica Polski?",
            options = listOf("Warszawa", "Kraków", "Gdańsk", "Wrocław"),
            correctAnswerIndex = 0
        ),
        Question(
            id = 2,
            text = "Ile dni ma tydzień?",
            options = listOf("5", "6", "7", "8"),
            correctAnswerIndex = 2
        ),
        Question(
            id = 3,
            text = "Który język jest używany do tworzenia aplikacji Android (oficjalnie)?",
            options = listOf("Swift", "Kotlin", "Ruby", "PHP"),
            correctAnswerIndex = 1
        ),
        Question(
            id = 4,
            text = "Co oznacza skrót JVM?",
            options = listOf("Java Virtual Machine", "Java Verified Model", "Java Variable Method", "Java Visual Manager"),
            correctAnswerIndex = 0
        )
    )
}

