package com.example.budgettrackingapp

import android.content.Context
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddAccount : AppCompatActivity() {

    private lateinit var categorySpinner: Spinner
    private lateinit var monthSpinner: Spinner
    private lateinit var descriptionInput: EditText
    private lateinit var amountInput: EditText
    private lateinit var saveButton: Button
    private lateinit var db: AppDatabase

    private val categories = listOf("Bills", "Needs", "Wants")
    private val months = listOf(
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_account)
        categorySpinner = findViewById(R.id.categorySpinner)
        monthSpinner = findViewById(R.id.monthSpinner)
        descriptionInput = findViewById(R.id.descriptionInput)
        amountInput = findViewById(R.id.amountInput)
        saveButton = findViewById(R.id.saveButton)

        db = AppDatabase.getDatabase(this)

        categorySpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, categories)
        monthSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, months)

        saveButton.setOnClickListener {
            val selectedCategory = categorySpinner.selectedItem.toString()
            val description = descriptionInput.text.toString().trim()
            val amountText = amountInput.text.toString().trim()
            val selectedMonth = monthSpinner.selectedItem.toString()

            if (description.isEmpty() || amountText.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val amount = amountText.toDoubleOrNull()
            if (amount == null || amount < 0) {
                Toast.makeText(this, "Enter a valid amount", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val userEmail = getCurrentUserEmail()

            val account = Account(
                user_email = userEmail,
                category = selectedCategory,
                description = description,
                amount = amount,
                month = selectedMonth
            )

            CoroutineScope(Dispatchers.IO).launch {
                db.accountDao().insertAccount(account)
                runOnUiThread {
                    Toast.makeText(this@AddAccount, "Account saved", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }

    private fun getCurrentUserEmail(): String {
        val sharedPref = getSharedPreferences("user_session", Context.MODE_PRIVATE)
        val email = sharedPref.getString("user_email", null) ?: ""
        return email
    }
}