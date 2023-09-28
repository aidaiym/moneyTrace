package com.example.moneytrace.data.database.repository

import com.example.moneytrace.AppDatabase
import com.example.moneytrace.data.database.Balance
import kotlinx.coroutines.flow.Flow


class Repository (
    private val db: AppDatabase,
) {
    private val balanceDao get() = db.balanceDao

    fun getBalance(): Flow<List<Balance>> = balanceDao.getBalance()
    suspend fun updateBalance(balance: Balance) = balanceDao.updateBalance(balance)
}