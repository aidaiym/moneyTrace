package com.example.moneytrace

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moneytrace.data.database.Balance
import com.example.moneytrace.data.database.BalanceDao
import com.example.moneytrace.data.database.Category
import com.example.moneytrace.data.database.CategoryDao
import com.example.moneytrace.data.database.FinancialTransactionDao
import com.example.moneytrace.data.database.FinancialTransactions

@Database(entities = [Category::class, FinancialTransactions::class, Balance::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val categoryDao: CategoryDao
    abstract val financialTransactionDao: FinancialTransactionDao
    abstract val balanceDao: BalanceDao
}