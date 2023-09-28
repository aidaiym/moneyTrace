package com.example.moneytrace.data.database

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface BalanceDao {
    @Query("SELECT * FROM Balance LIMIT 1")
    fun getBalance(): LiveData<Balance?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateBalance(balance: Balance)
}