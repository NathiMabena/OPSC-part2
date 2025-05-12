package com.example.budgettrackingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OnboardingScreen3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboarding_screen3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val option1 = findViewById<Button>(R.id.foodBtn)
        val option2 = findViewById<Button>(R.id.entertainmentBtn)
        val option3 = findViewById<Button>(R.id.transportBtn)
        val option4 = findViewById<Button>(R.id.shoppingBtn)
        val option5 = findViewById<Button>(R.id.funBtn)
        val option6 = findViewById<Button>(R.id.rentBtn)

        option1.setOnClickListener {
            val intent = Intent(this, OnboardingScreen4::class.java)
            startActivity(intent)
        }

        option2.setOnClickListener {
            val intent = Intent(this, OnboardingScreen4::class.java)
            startActivity(intent)
        }

        option3.setOnClickListener {
            val intent = Intent(this, OnboardingScreen4::class.java)
            startActivity(intent)
        }

        option4.setOnClickListener {
            val intent = Intent(this, OnboardingScreen4::class.java)
            startActivity(intent)
        }

        option5.setOnClickListener {
            val intent = Intent(this, OnboardingScreen4::class.java)
            startActivity(intent)
        }

        option6.setOnClickListener {
            val intent = Intent(this, OnboardingScreen4::class.java)
            startActivity(intent)
        }
    }
}