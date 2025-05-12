package com.example.budgettrackingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OnboardingScreen10 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboarding_screen10)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val option1 = findViewById<Button>(R.id.newBabyBtn)
        val option2 = findViewById<Button>(R.id.newCarBtn)
        val option3 = findViewById<Button>(R.id.vacationBtn)
        val option4 = findViewById<Button>(R.id.newHouseBtn)
        val option5 = findViewById<Button>(R.id.other4Btn)



        option1.setOnClickListener {
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }

        option2.setOnClickListener {
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }
        option3.setOnClickListener {
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }
        option4.setOnClickListener {
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }

        option5.setOnClickListener {
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }
    }
}