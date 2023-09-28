package com.example.moneytrace.data.database

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface FinancialTransactionDao {
    @Query("SELECT * FROM FinancialTransactions")
    fun getAllTransactions(): LiveData<List<FinancialTransactions>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: FinancialTransactions)

}