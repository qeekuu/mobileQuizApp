package com.example.mobilequizapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobilequizapp.data.Question
import com.example.mobilequizapp.data.SampleQuestions

class QuizViewModel : ViewModel() {

  // -- shuffle pytań raz przy starcie:
  private val questions: List<Question> = SampleQuestions.list.shuffled()

  // indeks pytania
  private val _currentIndex = MutableLiveData(0)
  val currentIndex: LiveData<Int> = _currentIndex

  // bieżące pytanie (z losową kolejnością opcji)
  private val _currentQuestion = MutableLiveData<DisplayQuestion?>().apply {
    value = makeDisplayQuestion(0)
  }
  val currentQuestion: LiveData<DisplayQuestion?> = _currentQuestion

  // wynik
  private val _score = MutableLiveData(0)
  val score: LiveData<Int> = _score

  // czy koniec?
  private val _isFinished = MutableLiveData(false)
  val isFinished: LiveData<Boolean> = _isFinished

  // przekształcony obiekt, który zawiera pytanie + losowo przemieszane opcje
  data class DisplayQuestion(
    val text: String,
    val options: List<String>,
    val correctAnswerPosition: Int
  )

  // helper: dla pytania idx zwraca DisplayQuestion
  private fun makeDisplayQuestion(idx: Int): DisplayQuestion? {
    val q = questions.getOrNull(idx) ?: return null
    // indeksy oryginalnych opcji
    val original = q.options.mapIndexed { i, t -> i to t }.shuffled()
    val opts = original.map { it.second }
    val correctPos = original.indexOfFirst { it.first == q.correctAnswerIndex }
    return DisplayQuestion(q.text, opts, correctPos)
  }

  fun selectAndConfirm(answerPos: Int) {
    // jeżeli dobrana pozycja = correctAnswerPosition, +1 punkt
    _currentQuestion.value?.let { dq ->
      if (answerPos == dq.correctAnswerPosition) {
        _score.value = (_score.value ?: 0) + 1
      }
    }
    // przejdź dalej lub zakończ
    val next = (_currentIndex.value ?: 0) + 1
    if (next < questions.size) {
      _currentIndex.value = next
      _currentQuestion.value = makeDisplayQuestion(next)
    } else {
      _isFinished.value = true
    }
  }

  fun totalQuestions() = questions.size

  fun resetQuiz() {
    _score.value = 0
    _currentIndex.value = 0
    _isFinished.value = false
    _currentQuestion.value = makeDisplayQuestion(0)
  }
}

