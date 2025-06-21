package com.example.mobilequizapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilequizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_SCORE    = "extra_score"
        const val EXTRA_TOTAL    = "extra_total"
        const val EXTRA_CATEGORY = "extra_category"
    }

    private lateinit var b: ActivityResultBinding

    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        b = ActivityResultBinding.inflate(layoutInflater)
        setContentView(b.root)

        // 1) Odczytujemy dane z Intentu
        val score    = intent.getIntExtra(EXTRA_SCORE, 0)
        val total    = intent.getIntExtra(EXTRA_TOTAL, 0)
        val category = intent.getStringExtra(EXTRA_CATEGORY) ?: "OS"  // ← tu

        // 2) Wyświetlamy wynik
        b.textResult.text = "Twój wynik: $score/$total"

        // 3) Zagraj ponownie — uruchamiamy MainActivity z tą samą kategorią
        b.buttonRestart.setOnClickListener {
            startActivity(
                Intent(this, MainActivity::class.java)
                    .putExtra("CATEGORY", category)  // ← używamy zmiennej
            )
            finish()
        }

        // 4) Wybór kategorii
        b.buttonCategory.setOnClickListener {
            startActivity(Intent(this, QuizSelectionActivity::class.java))
            finish()
        }

        // 5) Wyjdź
        b.buttonExit.setOnClickListener {
            finishAffinity()
        }
    }
}

