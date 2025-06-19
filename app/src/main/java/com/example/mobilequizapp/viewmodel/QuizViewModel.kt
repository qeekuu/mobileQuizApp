package com.example.mobilequizapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobilequizapp.data.Question
import com.example.mobilequizapp.data.SampleQuestions

class QuizViewModel : ViewModel() {

    private val questions: List<Question> = SampleQuestions.list

    // Indeks aktualnego pytania
    private val _currentIndex = MutableLiveData(0)
    val currentIndex: LiveData<Int> = _currentIndex

    // Bieżące pytanie
    private val _currentQuestion = MutableLiveData<Question?>().apply {
        value = questions.getOrNull(0)
    }
    val currentQuestion: LiveData<Question?> = _currentQuestion

    // Wybrana opcja (index) w aktualnym pytaniu, -1 jeśli nic
    private val _selectedOptionIndex = MutableLiveData(-1)
    val selectedOptionIndex: LiveData<Int> = _selectedOptionIndex

    // Score: liczba poprawnych odpowiedzi
    private val _score = MutableLiveData(0)
    val score: LiveData<Int> = _score

    // Czy quiz zakończony
    private val _isFinished = MutableLiveData(false)
    val isFinished: LiveData<Boolean> = _isFinished

    // Ustawienie wybranej opcji
    fun selectOption(index: Int) {
        _selectedOptionIndex.value = index
    }

    // Potwierdzenie odpowiedzi i przejście dalej / zakończenie
    fun confirmAnswer() {
        val idx = _currentIndex.value ?: 0
        val question = questions.getOrNull(idx) ?: return
        val selected = _selectedOptionIndex.value ?: -1
        if (selected == question.correctAnswerIndex) {
            _score.value = (_score.value ?: 0) + 1
        }
        // Reset zaznaczenia na następnym
        _selectedOptionIndex.value = -1

        // Przejście do następnego pytania lub zakończenie
        if (idx + 1 < questions.size) {
            val nextIdx = idx + 1
            _currentIndex.value = nextIdx
            _currentQuestion.value = questions.getOrNull(nextIdx)
        } else {
            _isFinished.value = true
        }
    }

    // Reset quizu (aby można było zagrać ponownie)
    fun resetQuiz() {
        _currentIndex.value = 0
        _currentQuestion.value = questions.getOrNull(0)
        _selectedOptionIndex.value = -1
        _score.value = 0
        _isFinished.value = false
    }

    // Liczba pytań
    fun totalQuestions(): Int = questions.size
}

