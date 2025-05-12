package com.example.budgettrackingapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Login : AppCompatActivity() {

    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var loginButton: Button
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailInput = findViewById(R.id.emailInput)
        passwordInput = findViewById(R.id.passwordInput)
        loginButton = findViewById(R.id.loginBtn)

        db = AppDatabase.getDatabase(this)

        loginButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString()

            // Validation
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Database operations in background thread
            CoroutineScope(Dispatchers.IO).launch {
                val user = db.userDao().getUserByEmail(email)

                runOnUiThread {
                    when {
                        user == null -> {
                            Toast.makeText(this@Login, "Invalid email, please sign up", Toast.LENGTH_SHORT).show()
                        }
                        user.password != password -> {
                            Toast.makeText(this@Login, "Incorrect password", Toast.LENGTH_SHORT).show()
                        }
                        else -> {
                            // Successful login
                            val intent = Intent(this@Login, WelcomePage::class.java)
                            intent.putExtra("USER_NAME", user.name)
                            startActivity(intent)
                            finish()
                            /*val sharedPref = getSharedPreferences("user_session", Context.MODE_PRIVATE)
                            with(sharedPref.edit()) {
                                putString("user_email", email)
                                apply()
                            }*/

                        }
                    }
                }
            }
        }
    }
}