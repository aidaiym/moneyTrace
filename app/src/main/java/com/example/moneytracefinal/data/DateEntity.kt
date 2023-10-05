package com.example.moneytracefinal.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "date_table",
    indices = [Index(value = ["date"], unique = true)])
data class DateEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Long = 0,
    @ColumnInfo(name = "date")
    val date: String,
)
