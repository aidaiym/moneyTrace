package com.example.moneytrace.data.database

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


interface FinancialTransactionDao {
    @Query("SELECT * FROM FinancialTransactions")
    fun getAllTransactions(): Flow<List<FinancialTransactions>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: FinancialTransactions)

}