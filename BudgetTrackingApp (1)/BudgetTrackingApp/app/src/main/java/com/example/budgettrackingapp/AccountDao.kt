package com.example.budgettrackingapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AccountDao {
    @Insert
    suspend fun insertAccount(account: Account)

    @Query("SELECT * FROM accounts WHERE user_email = :email")
    suspend fun getAccountsByUser(email: String): List<Account>

    @Query("SELECT * FROM accounts WHERE user_email = :email AND month = :month")
    fun getAccountsByUserAndMonth(email: String, month: String): List<Account>

}