package com.example.moneytracefinal.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        BalanceEntity::class,
        CategoryEntity::class,
        FinancialTransactions::class,
        DateEntity::class,
    ],
    version = 2
)

abstract class MainDb : RoomDatabase() {
    abstract val balanceDao: BalanceDao
    abstract val categoryDao: CategoryDao
    abstract val financialTransactionsDao: FinancialTransactionDao
    abstract val dateDao: DateDao
    companion object {
        fun createDataBase(context: Context):MainDb {
            return Room.databaseBuilder(
                context,
                MainDb::class.java,
                "MainDb"
            ).build()
        }
    }
}