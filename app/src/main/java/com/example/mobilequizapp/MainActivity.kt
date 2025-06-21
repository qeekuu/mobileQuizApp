package com.example.mobilequizapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.lifecycle.ViewModelProvider
import com.example.mobilequizapp.databinding.ActivityMainBinding
import com.example.mobilequizapp.viewmodel.QuizViewModel
import com.example.mobilequizapp.viewmodel.QuizViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var vm: QuizViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val category = intent.getStringExtra("CATEGORY") ?: "OS"
        val factory = QuizViewModelFactory(category)
        vm = ViewModelProvider(this, factory).get(QuizViewModel::class.java)

        vm.currentQuestion.observe(this) { dq -> renderQuestion(dq) }
        vm.currentIndex.observe(this) { idx ->
            binding.textQuestionNumber.text = "Pytanie ${idx+1}/${vm.totalQuestions()}"
            binding.buttonConfirm.text =
                if (idx == vm.totalQuestions()-1) "Zakończ" else "Dalej"
            binding.buttonConfirm.isEnabled = false
        }
        vm.score.observe(this) { binding.textScore.text = "Wynik: $it" }
        vm.isFinished.observe(this) {
            if (it) {
                startActivity(
                    Intent(this, ResultActivity::class.java)
                        .putExtra(ResultActivity.EXTRA_SCORE, vm.score.value)
                        .putExtra(ResultActivity.EXTRA_TOTAL, vm.totalQuestions())
                )
                finish()
            }
        }

        binding.buttonConfirm.setOnClickListener {
            // wybór metody wg typu pytania
            vm.currentQuestion.value?.let { dq ->
                if (dq.correctAnswerPositionList.isNotEmpty()) {
                    // multi-choice
                    val selected = binding.checkboxContainer.children
                        .filter { (it as CheckBox).isChecked }
                        .map { it.id }
                        .toList()
                    vm.selectAndConfirmMulti(selected)
                } else {
                    // single-choice
                    val checkedId = binding.radioGroupOptions.checkedRadioButtonId
                    vm.selectAndConfirmSingle(checkedId)
                }
            }
        }
    }

    private fun renderQuestion(dq: QuizViewModel.DisplayQuestion?) {
        if (dq == null) return

        binding.textQuestion.text = dq.text
        binding.radioGroupOptions.removeAllViews()
        binding.checkboxContainer.removeAllViews()

        // jeśli lista poprawnych indeksów niepusta → multi-choice
        if (dq.correctAnswerPositionList.isNotEmpty()) {
            binding.radioGroupOptions.visibility = View.GONE
            binding.checkboxContainer.visibility = View.VISIBLE

            dq.options.forEachIndexed { i, opt ->
                CheckBox(this).apply {
                    id = i; text = opt; textSize = 16f
                    setOnCheckedChangeListener { _, _ ->
                        binding.buttonConfirm.isEnabled =
                            binding.checkboxContainer.children
                                .any { (it as CheckBox).isChecked }
                    }
                }.also { binding.checkboxContainer.addView(it) }
            }

        } else {
            // single-choice
            binding.radioGroupOptions.visibility = View.VISIBLE
            binding.checkboxContainer.visibility = View.GONE

            dq.options.forEachIndexed { i, opt ->
                RadioButton(this).apply {
                    id = i; text = opt; textSize = 16f
                }.also { binding.radioGroupOptions.addView(it) }
            }
            binding.radioGroupOptions.setOnCheckedChangeListener { _, _ ->
                binding.buttonConfirm.isEnabled = true
            }
        }

        binding.buttonConfirm.isEnabled = false
    }
}

