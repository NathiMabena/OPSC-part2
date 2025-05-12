package com.example.budgettrackingapp


import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WelcomePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcomepage) // Make sure this matches your layout filename

        val name = intent.getStringExtra("USER_NAME")
        val welcomeText = findViewById<TextView>(R.id.welcomeTextView)
        val sharedPref = getSharedPreferences("user_session", Context.MODE_PRIVATE)
        val email = sharedPref.getString("user_email", "User")

        val db = AppDatabase.getDatabase(this)


        if (!name.isNullOrEmpty()) {
            welcomeText.text = "Hi: $name"
        } else {
            welcomeText.text = "Welcome!"
        }
    }
}