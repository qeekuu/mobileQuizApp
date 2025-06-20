package com.example.mobilequizapp

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilequizapp.databinding.ActivityMainBinding
import com.example.mobilequizapp.viewmodel.QuizViewModel

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
  private val vm: QuizViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    vm.currentQuestion.observe(this) { dq ->
      renderQuestion(dq)
    }
    vm.currentIndex.observe(this) { idx ->
      binding.textQuestionNumber.text = "Pytanie ${idx+1}/${vm.totalQuestions()}"
      binding.buttonConfirm.text =
        if (idx == vm.totalQuestions()-1) "Zakończ" else "Dalej"
      // na każdą zmianę pytania blokujemy przycisk
      binding.buttonConfirm.isEnabled = false
    }
    vm.score.observe(this) { score ->
      binding.textScore.text = "Wynik: $score"
    }
    vm.isFinished.observe(this) { end ->
      if (end) {
        startActivity(
          Intent(this, ResultActivity::class.java)
            .putExtra(ResultActivity.EXTRA_SCORE, vm.score.value)
            .putExtra(ResultActivity.EXTRA_TOTAL, vm.totalQuestions())
        )
        finish()
      }
    }

    binding.buttonConfirm.setOnClickListener {
      // odczytujemy zaznaczoną opcję
      val checked = binding.radioGroupOptions.checkedRadioButtonId
      vm.selectAndConfirm(checked)
    }
  }

  private fun renderQuestion(dq: QuizViewModel.DisplayQuestion?) {
    binding.radioGroupOptions.removeAllViews()
    if (dq == null) return
    binding.textQuestion.text = dq.text

    dq.options.forEachIndexed { i, opt ->
      RadioButton(this).apply {
        id = i
        text = opt
        textSize = 16f
      }.also { rb ->
        binding.radioGroupOptions.addView(rb)
      }
    }
    // blokujemy potwierdź dopóki nie wybiorą
    binding.buttonConfirm.isEnabled = false
    binding.radioGroupOptions.setOnCheckedChangeListener { _, _ ->
      binding.buttonConfirm.isEnabled = true
    }
  }
}

