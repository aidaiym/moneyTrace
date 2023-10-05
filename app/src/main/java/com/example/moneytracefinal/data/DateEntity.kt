package com.example.moneytracefinal.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "date_table")
data class DateEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Long = 0,
    @ColumnInfo(name = "date")
    val date: String,
)
