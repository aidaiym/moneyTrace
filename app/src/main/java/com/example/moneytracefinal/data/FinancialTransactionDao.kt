package com.example.moneytracefinal.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FinancialTransactionDao {
    @Query("SELECT * FROM FinancialTransactions")
    fun getAllTransactions(): Flow<List<FinancialTransactions>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: FinancialTransactions)

    @Query("SELECT * FROM FinancialTransactions WHERE date LIKE :chosenDate || '%'")
    fun getAllTransactionsByMonth(chosenDate: String): Flow<List<FinancialTransactions>>
}