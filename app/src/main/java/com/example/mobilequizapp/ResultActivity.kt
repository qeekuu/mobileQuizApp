package com.example.mobilequizapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilequizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
  companion object {
    const val EXTRA_SCORE = "extra_score"
    const val EXTRA_TOTAL = "extra_total"
  }

  private lateinit var b: ActivityResultBinding

  override fun onCreate(s: Bundle?) {
    super.onCreate(s)
    b = ActivityResultBinding.inflate(layoutInflater)
    setContentView(b.root)

    val score = intent.getIntExtra(EXTRA_SCORE, 0)
    val total = intent.getIntExtra(EXTRA_TOTAL, 0)
    b.textResult.text = "Twój wynik: $score/$total"

    b.buttonRestart.setOnClickListener {
      startActivity(Intent(this, MainActivity::class.java))
      finish()
    }
    b.buttonExit.setOnClickListener {
      finishAffinity()
    }
  }
}

