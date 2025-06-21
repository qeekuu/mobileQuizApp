package com.example.mobilequizapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilequizapp.databinding.ActivitySelectionBinding

class QuizSelectionActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOSSingle.setOnClickListener {
            launchQuiz("OS")
        }
        binding.buttonDBSingle.setOnClickListener {
            launchQuiz("DB")
        }
    }

    private fun launchQuiz(category: String) {
        startActivity(
            Intent(this, MainActivity::class.java)
                .putExtra("CATEGORY", category)
        )
        finish()
    }
}

