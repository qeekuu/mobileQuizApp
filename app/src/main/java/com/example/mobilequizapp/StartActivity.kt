package com.example.mobilequizapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilequizapp.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
  private lateinit var binding: ActivityStartBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityStartBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.buttonStart.setOnClickListener {
      startActivity(Intent(this, MainActivity::class.java))
      finish()  // nie wracamy na ekran startowy po quizie
    }
  }
}

