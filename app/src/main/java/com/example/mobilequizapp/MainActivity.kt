package com.example.mobilequizapp

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.mobilequizapp.databinding.ActivityMainBinding
import com.example.mobilequizapp.viewmodel.QuizViewModel
import com.example.mobilequizapp.ResultActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: QuizViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obserwuj LiveData
        viewModel.currentQuestion.observe(this, Observer { question ->
            updateQuestionUI(question)
        })
        viewModel.currentIndex.observe(this, Observer { index ->
            updateQuestionNumberUI(index)
            // Tekst przycisku: jeżeli ostatnie pytanie, zmień z “Potwierdź” na “Zakończ”
            val total = viewModel.totalQuestions()
            if (index == total - 1) {
                binding.buttonConfirm.text = "Zakończ"
            } else {
                binding.buttonConfirm.text = "Dalej"
            }
        })
        viewModel.selectedOptionIndex.observe(this, Observer { selectedIdx ->
            // Włącz/wyłącz przycisk
            binding.buttonConfirm.isEnabled = (selectedIdx >= 0)
            // Ustaw zaznaczenie w RadioGroup (przy przywracaniu stanu)
            // Ale ponieważ generujemy RadioButtons dynamicznie, przy updateQuestionUI ustawiamy zaznaczenie
        })
        viewModel.isFinished.observe(this, Observer { finished ->
            if (finished) {
                // Przechodzimy do ResultActivity
                val score = viewModel.score.value ?: 0
                val total = viewModel.totalQuestions()
                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra(ResultActivity.EXTRA_SCORE, score)
                    putExtra(ResultActivity.EXTRA_TOTAL, total)
                }
                startActivity(intent)
                // Opcjonalnie zakończ MainActivity, aby po powrocie z wyniku zacząć od nowa
                finish()
            }
        })

        // Kliknięcie potwierdzenia
        binding.buttonConfirm.setOnClickListener {
            viewModel.confirmAnswer()
        }
    }

    private fun updateQuestionNumberUI(index: Int) {
        val total = viewModel.totalQuestions()
        binding.textQuestionNumber.text = "Pytanie ${index + 1}/$total"
    }

    private fun updateQuestionUI(question: com.example.mobilequizapp.data.Question?) {
        // Usuń poprzednie RadioButtony
        binding.radioGroupOptions.removeAllViews()

        if (question == null) {
            binding.textQuestion.text = "Brak pytania"
            binding.buttonConfirm.isEnabled = false
            return
        }

        binding.textQuestion.text = question.text

        // Dla każdej opcji twórz RadioButton
        question.options.forEachIndexed { idx, optionText ->
            val radioButton = RadioButton(this).apply {
                id = idx  // ID = index opcji
                text = optionText
                textSize = 16f
                // Opcjonalnie padding/margines:
                // setPadding(8, 8, 8, 8)
            }
            // Dodaj do grupy
            binding.radioGroupOptions.addView(radioButton)

            // Jeśli w ViewModel istniało zaznaczenie (np. przy przywracaniu stanu), zaznacz odpowiedni:
            val selected = viewModel.selectedOptionIndex.value ?: -1
            if (selected == idx) {
                radioButton.isChecked = true
            }
        }

        // Listener zmiany zaznaczenia:
        binding.radioGroupOptions.setOnCheckedChangeListener { group: RadioGroup, checkedId: Int ->
            if (checkedId >= 0) {
                viewModel.selectOption(checkedId)
            } else {
                viewModel.selectOption(-1)
            }
        }
        // Na początku, gdy nowe pytanie, przywraciliśmy selectedOptionIndex = -1 w ViewModel.resetQuiz() lub confirmAnswer,
        // więc nie powinno być nic zaznaczone i przyciskConfirm będzie disabled dopóki użytkownik nie wybierze.
    }
}

