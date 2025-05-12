package com.example.budgettrackingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OnboardingScreen7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboarding_screen7)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val option1 = findViewById<Button>(R.id.carLoansBtn)
        val option2 = findViewById<Button>(R.id.studentLoansBtn)
        val option3 = findViewById<Button>(R.id.personalLoansBtn)
        val option4 = findViewById<Button>(R.id.laybuyBtn)
        val option5 = findViewById<Button>(R.id.creditCardBtn)
        val option6 = findViewById<Button>(R.id.other1Btn)


        option1.setOnClickListener {
            val intent = Intent(this, OnboardingScreen8::class.java)
            startActivity(intent)
        }

        option2.setOnClickListener {
            val intent = Intent(this, OnboardingScreen8::class.java)
            startActivity(intent)
        }
        option3.setOnClickListener {
            val intent = Intent(this, OnboardingScreen8::class.java)
            startActivity(intent)
        }
        option4.setOnClickListener {
            val intent = Intent(this, OnboardingScreen8::class.java)
            startActivity(intent)
        }

        option5.setOnClickListener {
            val intent = Intent(this, OnboardingScreen8::class.java)
            startActivity(intent)
        }
        option6.setOnClickListener {
            val intent = Intent(this, OnboardingScreen8::class.java)
            startActivity(intent)
        }
    }
}