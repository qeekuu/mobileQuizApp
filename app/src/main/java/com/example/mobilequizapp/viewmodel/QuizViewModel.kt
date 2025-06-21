package com.example.mobilequizapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobilequizapp.data.Question

class QuizViewModel(
    questionSource: List<Question>
) : ViewModel() {

    // tasujemy listę pytań raz przy starcie
    private val questions: List<Question> = questionSource.shuffled()

    // indeks bieżącego pytania
    private val _currentIndex = MutableLiveData(0)
    val currentIndex: LiveData<Int> = _currentIndex

    // bieżące pytanie (z wylosowanymi opcjami)
    private val _currentQuestion = MutableLiveData<DisplayQuestion?>().apply {
        value = makeDisplayQuestion(0)
    }
    val currentQuestion: LiveData<DisplayQuestion?> = _currentQuestion

    // wynik
    private val _score = MutableLiveData(0)
    val score: LiveData<Int> = _score

    // flaga zakończenia quizu
    private val _isFinished = MutableLiveData(false)
    val isFinished: LiveData<Boolean> = _isFinished

    /**
     * Reprezentacja pytania gotowa do wyświetlenia:
     * - text: treść pytania
     * - options: lista opcji w losowej kolejności
     * - correctAnswerPosition: pozycja poprawnej odpowiedzi (dla single)
     * - correctAnswerPositionList: lista pozycji poprawnych (dla multi)
     */
    data class DisplayQuestion(
        val text: String,
        val options: List<String>,
        val correctAnswerPosition: Int?,          // single-choice
        val correctAnswerPositionList: List<Int>  // multi-choice
    )

    // tworzy DisplayQuestion dla pytania o indeksie idx
    private fun makeDisplayQuestion(idx: Int): DisplayQuestion? {
        val q = questions.getOrNull(idx) ?: return null

        // parujemy każdą opcję z jej oryginalnym indeksem, a potem losujemy kolejność
        val original = q.options.mapIndexed { i, t -> i to t }.shuffled()
        val opts = original.map { it.second }

        // dla single-choice
        val correctPosSingle = q.correctAnswerIndex
            ?.let { origIdx -> original.indexOfFirst { it.first == origIdx } }

        // dla multi-choice
        val correctPosList = q.correctAnswerIndices
            .map { origIdx -> original.indexOfFirst { it.first == origIdx } }

        return DisplayQuestion(q.text, opts, correctPosSingle, correctPosList)
    }

    /** Obsługa wyboru w trybie single-choice */
    fun selectAndConfirmSingle(answerPos: Int) {
        _currentQuestion.value?.let { dq ->
            if (answerPos == dq.correctAnswerPosition) {
                _score.value = (_score.value ?: 0) + 1
            }
        }
        goToNext()
    }

    /** Obsługa wyboru w trybie multi-choice */
    fun selectAndConfirmMulti(selected: List<Int>) {
        _currentQuestion.value?.let { dq ->
            if (selected.sorted() == dq.correctAnswerPositionList.sorted()) {
                _score.value = (_score.value ?: 0) + 1
            }
        }
        goToNext()
    }

    // wspólna logika przejścia do następnego pytania lub zakończenia
    private fun goToNext() {
        val next = (_currentIndex.value ?: 0) + 1
        if (next < questions.size) {
            _currentIndex.value = next
            _currentQuestion.value = makeDisplayQuestion(next)
        } else {
            _isFinished.value = true
        }
    }

    /** Łączna liczba pytań w quizie */
    fun totalQuestions(): Int = questions.size

    /** Restart quizu do stanu początkowego */
    fun resetQuiz() {
        _score.value = 0
        _currentIndex.value = 0
        _isFinished.value = false
        _currentQuestion.value = makeDisplayQuestion(0)
    }
}

