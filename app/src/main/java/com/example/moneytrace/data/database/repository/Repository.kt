package com.example.moneytrace.data.database.repository

import com.example.moneytrace.AppDatabase
import com.example.moneytrace.data.database.Balance
import kotlinx.coroutines.flow.Flow


class Repository (
    private val db: AppDatabase,
) {
    private val categoryDao get() = db.balanceDao

    fun getBalance(): Flow<List<Balance>> = categoryDao.getBalance()
    suspend fun updateBalance(balance: Balance) = categoryDao.updateBalance(balance)
}