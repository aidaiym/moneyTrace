package com.example.moneytracefinal.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "balance_table")
data class BalanceEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Long = 0,
    @ColumnInfo(name = "balance")
    val balance: Long,
)
