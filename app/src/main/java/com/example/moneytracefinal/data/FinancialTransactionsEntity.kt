package com.example.moneytracefinal.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "FinancialTransactions", foreignKeys = [
    ForeignKey(entity = CategoryEntity::class, parentColumns = ["id"], childColumns = ["categoryId"]),
    ForeignKey(entity = DateEntity::class, parentColumns = ["date"], childColumns = ["date"])
])
data class FinancialTransactions(
    @PrimaryKey(autoGenerate = true)
    val id: Long =0,
    @ColumnInfo(name = "summa")
    val summa: Long,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "categoryId")
    val categoryId: Long,
)