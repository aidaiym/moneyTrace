package com.example.moneytrace

import android.app.Application
import android.util.Log
import androidx.room.Room
import com.example.moneytrace.data.database.BalanceDao
import com.example.moneytrace.data.database.CategoryDao
import com.example.moneytrace.data.database.FinancialTransactionDao

class MainApplication : Application() {
    private lateinit var db: AppDatabase


    override fun onCreate() {
        super.onCreate()
        Log.d("MyLog", "1")
        db = Room.databaseBuilder(this, AppDatabase::class.java, "app-database")
            .fallbackToDestructiveMigration()
            .build()
        financialTransactionsDao = db.financialTransactionDao
        categoryDao = db.categoryDao
        balanceDao = db.balanceDao

        Log.d("MyLog", "2")
    }

    companion object{
        lateinit var financialTransactionsDao: FinancialTransactionDao
        lateinit var categoryDao: CategoryDao
        lateinit var balanceDao: BalanceDao
    }
}