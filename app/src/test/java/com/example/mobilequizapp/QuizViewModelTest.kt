package com.example.mobilequizapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.mobilequizapp.viewmodel.QuizViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class QuizViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: QuizViewModel

    @Before
    fun setup() {
        viewModel = QuizViewModel()
    }

    @Test
    fun resetQuiz_initialState() {
        assertEquals(0, viewModel.currentIndex.value)
        assertEquals(0, viewModel.score.value)
        assertFalse(viewModel.isFinished.value ?: false)
    }

    @Test
    fun correctAnswer_incrementsScoreAndMovesNext() {
        // Załóżmy, że w SampleQuestions pierwsze pytanie ma correctAnswerIndex = 0
        viewModel.selectOption(0)
        viewModel.confirmAnswer()
        assertEquals(1, viewModel.score.value)
        assertEquals(1, viewModel.currentIndex.value)
    }

    @Test
    fun wrongAnswer_doesNotIncrementScore() {
        // Załóżmy poprawna 0; wybieramy 1
        viewModel.selectOption(1)
        viewModel.confirmAnswer()
        assertEquals(0, viewModel.score.value)
        assertEquals(1, viewModel.currentIndex.value)
    }

    @Test
    fun finishQuiz_setsIsFinishedTrue() {
        val total = viewModel.totalQuestions()
        // Dla prostoty: zawsze wybieramy poprawną opcję
        for (i in 0 until total) {
            val idx = viewModel.currentIndex.value ?: 0
            val question = viewModel.currentQuestion.value!!
            viewModel.selectOption(question.correctAnswerIndex)
            viewModel.confirmAnswer()
        }
        assertTrue(viewModel.isFinished.value ?: false)
    }
}

