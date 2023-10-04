package com.example.moneytracefinal.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BalanceDao {
    @Query("SELECT * FROM balance_table LIMIT 1")
    fun getBalance(): Flow<List<BalanceEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateBalance(balance: BalanceEntity)
}