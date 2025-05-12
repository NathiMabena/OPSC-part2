package com.example.budgettrackingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OnboardingScreen6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboarding_screen6)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val option1 = findViewById<Button>(R.id.yesMortgageBtn)
        val option2 = findViewById<Button>(R.id.noMortgageBtn)



        option1.setOnClickListener {
            val intent = Intent(this, OnboardingScreen7::class.java)
            startActivity(intent)
        }

        option2.setOnClickListener {
            val intent = Intent(this, OnboardingScreen7::class.java)
            startActivity(intent)
        }

    }
}