package com.example.mobilequizapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobilequizapp.data.Question
import com.example.mobilequizapp.data.SampleQuestions

// w pliku QuizViewModel.kt, nad klasą QuizViewModel
data class ShuffledQuestion(
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)

class QuizViewModel : ViewModel() {

    // Wygenerowana i wylosowana lista pytań do bieżącej gry
    private var questions: List<ShuffledQuestion> = listOf()

    // Indeks aktualnego pytania w tej liście
    private val _currentIndex = MutableLiveData(0)
    val currentIndex: LiveData<Int> = _currentIndex

    // Bieżące pytanie – ShuffledQuestion
    private val _currentQuestion = MutableLiveData<ShuffledQuestion?>(null)
    val currentQuestion: LiveData<ShuffledQuestion?> = _currentQuestion

    // Punktacja na żywo
    private val _score = MutableLiveData(0)
    val score: LiveData<Int> = _score

    // Czy quiz zakończony
    private val _isFinished = MutableLiveData(false)
    val isFinished: LiveData<Boolean> = _isFinished

    // Pomocnicze flagi
    private var answeredThisQuestion = false

    // LiveData sygnalizujące czy ostatnia odpowiedź była poprawna (opcjonalnie)
    private val _isAnswerCorrect = MutableLiveData<Boolean?>()
    val isAnswerCorrect: LiveData<Boolean?> = _isAnswerCorrect

    init {
        resetQuiz()
    }

    /** Miesza pytania i dla każdego opcje, zwraca ShuffledQuestion listę */
    private fun generateShuffledQuestions(): List<ShuffledQuestion> {
        return SampleQuestions.list
            .shuffled()  // losujemy kolejność pytań
            .map { q ->
                // parujemy każdą opcję z jej oryginalnym indeksem
                val paired = q.options.mapIndexed { idx, opt -> opt to idx }
                    .shuffled() // losujemy kolejność opcji
                val opts = paired.map { it.first }
                // nowy indeks poprawnej opcji to pozycja w poshuffled parze, gdzie oryginalny idx==q.correctAnswerIndex
                val newCorrect = paired.indexOfFirst { it.second == q.correctAnswerIndex }
                ShuffledQuestion(q.text, opts, newCorrect)
            }
    }

    /** Resetuje grę: punktacja, shuffle, pierwszy question */
    fun resetQuiz() {
        _score.value = 0
        _isFinished.value = false
        _isAnswerCorrect.value = null
        answeredThisQuestion = false

        questions = generateShuffledQuestions()
        _currentIndex.value = 0
        _currentQuestion.value = questions[0]
    }

    /** Użytkownik wybrał opcję o indeksie [index] */
    fun selectOption(index: Int) {
        if (answeredThisQuestion) return
        val question = _currentQuestion.value ?: return

        // inkrementacja tylko raz na pytanie
        if (index == question.correctAnswerIndex) {
            _score.value = (_score.value ?: 0) + 1
            _isAnswerCorrect.value = true
        } else {
            _isAnswerCorrect.value = false
        }
        answeredThisQuestion = true
    }

    /** Potwierdzenie i przejście do następnego pytania lub zakończenie */
    fun confirmAnswer() {
        // resetujemy flagi pod kolejne pytanie
        answeredThisQuestion = false
        _isAnswerCorrect.value = null

        val next = (_currentIndex.value ?: 0) + 1
        if (next < questions.size) {
            _currentIndex.value = next
            _currentQuestion.value = questions[next]
        } else {
            _isFinished.value = true
        }
    }

    /** Całkowita liczba pytań w tej grze */
    fun totalQuestions(): Int = questions.size
}

