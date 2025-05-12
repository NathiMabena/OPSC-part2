package com.example.budgettrackingapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accounts")
data class Account(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val user_email: String,
    val category: String,
    val description: String,
    val amount: Double,
    val month: String
)
