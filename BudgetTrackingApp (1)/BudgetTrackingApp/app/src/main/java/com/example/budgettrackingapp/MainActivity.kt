package com.example.budgettrackingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

        val newUser = findViewById<Button>(R.id.tryButton)
        newUser.setOnClickListener {
            val Intent = Intent(this, OnboardingScreen2::class.java)
            startActivity(Intent)
        }

        val oldUser = findViewById<Button>(R.id.loginButton)
        oldUser.setOnClickListener {
            val Intent = Intent(this, Login::class.java)
            startActivity(Intent)


        }
    }
}