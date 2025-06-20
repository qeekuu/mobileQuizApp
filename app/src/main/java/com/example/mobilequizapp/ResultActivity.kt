package com.example.mobilequizapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilequizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

  private lateinit var binding: ActivityResultBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityResultBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val score = intent.getIntExtra(EXTRA_SCORE, 0)
    val total = intent.getIntExtra(EXTRA_TOTAL, 0)
    binding.textResult.text = "Twój wynik: $score / $total"

    binding.buttonRestart.setOnClickListener {
      startActivity(Intent(this, MainActivity::class.java))
      finish()
    }

    binding.buttonExit.setOnClickListener {
      // Zamyka cały task i wychodzi z aplikacji:
      finishAffinity()
    }
  }

  companion object {
    const val EXTRA_SCORE = "extra_score"
    const val EXTRA_TOTAL = "extra_total"
  }
}

