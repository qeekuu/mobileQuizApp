package com.example.mobilequizapp.data

/*
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
*/

object SampleQuestions {
	// Pytania z systemów
    val osSingle: List<Question> = listOf(
        Question(1, "Co to jest jądro systemu operacyjnego?", listOf("Kernel", "Shell", "GUI", "BIOS"), correctAnswerIndex = 0),
        // ... więcej pytań SO single ...
    )
    val osMulti: List<Question> = listOf(
        Question(1, "Które z poniższych to procesy jądra?", listOf("Scheduler", "File system", "Shell", "Memory manager"), correctAnswerIndices = listOf(0,1,3)),
        // ... więcej pytań SO multi ...
    )

	// Pytania z baz
    val dbSingle: List<Question> = listOf(
        Question(1, "Co oznacza SQL?", listOf("Structured Query Language", "Simple Query Language", "Sequential Query List", "Standard Query List"), correctAnswerIndex = 0),
        // ... więcej pytań BD single ...
    )
    val dbMulti: List<Question> = listOf(
        Question(1, "Które typy JOIN zwracają tylko wspólne wiersze?", listOf("INNER", "OUTER", "LEFT", "RIGHT"), correctAnswerIndices = listOf(0)),
        // ... więcej pytań BD multi ...
    )
}
