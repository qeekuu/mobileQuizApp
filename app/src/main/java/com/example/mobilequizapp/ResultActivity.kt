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

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Pobierz wynik z Intent
        val score = intent.getIntExtra(EXTRA_SCORE, 0)
        val total = intent.getIntExtra(EXTRA_TOTAL, 0)

        binding.textResult.text = "Twój wynik: $score / $total"

        binding.buttonRestart.setOnClickListener {
            // Aby zrestartować quiz, wróć do MainActivity:
            val intent = Intent(this, MainActivity::class.java).apply {
                // Można dodać flagi, aby wyczyścić stos:
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            }
            startActivity(intent)
            finish()
        }
    }
}

