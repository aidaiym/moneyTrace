package com.example.moneytrace.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "FinancialTransactions", foreignKeys = [ForeignKey (entity = Category::class, parentColumns = ["id"], childColumns = ["categoryId"])])
data class FinancialTransactions(
    @PrimaryKey(autoGenerate = true)
    val id: Long =0,
    @ColumnInfo(name = "summa")
    val summa: Long,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "date")
    val date: Date,
    @ColumnInfo(name = "categoryId")
    val categoryId: Long,
)
