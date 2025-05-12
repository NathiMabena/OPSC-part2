package com.example.budgettrackingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OnboardingScreen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboarding_screen2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val option1 = findViewById<Button>(R.id.option1)
        val option2 = findViewById<Button>(R.id.option2)
        val option3 = findViewById<Button>(R.id.option3)
        val option4 = findViewById<Button>(R.id.option4)
        val option5 = findViewById<Button>(R.id.option5)
        val option6 = findViewById<Button>(R.id.option6)

        option1.setOnClickListener {
            val intent = Intent(this, OnboardingScreen3::class.java)
            startActivity(intent)
        }

        option2.setOnClickListener {
            val intent = Intent(this, OnboardingScreen3::class.java)
            startActivity(intent)
        }

        option3.setOnClickListener {
            val intent = Intent(this, OnboardingScreen3::class.java)
            startActivity(intent)
        }

        option4.setOnClickListener {
            val intent = Intent(this, OnboardingScreen3::class.java)
            startActivity(intent)
        }

        option5.setOnClickListener {
            val intent = Intent(this, OnboardingScreen3::class.java)
            startActivity(intent)
        }

        option6.setOnClickListener {
            val intent = Intent(this, OnboardingScreen3::class.java)
            startActivity(intent)
        }
    }
}