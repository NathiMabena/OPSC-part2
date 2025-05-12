package com.example.budgettrackingapp

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class Dashboard : AppCompatActivity() {
    private lateinit var db: AppDatabase
    private lateinit var accountDao: AccountDao
    private lateinit var email: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        db = AppDatabase.getDatabase(this)
        accountDao = db.accountDao()

        email = getSharedPreferences("user_session", Context.MODE_PRIVATE)
            .getString("user_email", null) ?: ""

        val monthSpinner = findViewById<Spinner>(R.id.monthSpinner)
        val totalTextView = findViewById<TextView>(R.id.totalTextView)
        val listView = findViewById<ListView>(R.id.accountListView)

        val months = resources.getStringArray(R.array.months_array)
        monthSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, months)

        monthSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedMonth = parent.getItemAtPosition(position).toString()
                CoroutineScope(Dispatchers.IO).launch {
                    val accounts = accountDao.getAccountsByUserAndMonth(email, selectedMonth)

                    val grouped = accounts.groupBy { it.category }
                    val totalByCategory = grouped.mapValues { it.value.sumOf { acc -> acc.amount } }

                    val allItems = accounts.map {
                        "${it.category}: ${it.description} - R${it.amount}"
                    }

                    val totalText = """
                        Total Bills: R${totalByCategory["Bills"] ?: 0.0}
                        Total Needs: R${totalByCategory["Needs"] ?: 0.0}
                        Total Wants: R${totalByCategory["Wants"] ?: 0.0}
                    """.trimIndent()

                    withContext(Dispatchers.Main) {
                        totalTextView.text = totalText
                        listView.adapter = ArrayAdapter(this@Dashboard, android.R.layout.simple_list_item_1, allItems)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }
}
