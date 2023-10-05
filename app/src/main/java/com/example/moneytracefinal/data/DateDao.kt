package com.example.moneytracefinal.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DateDao {
    @Query("SELECT * FROM date_table")
    fun getDate(): Flow<List<DateEntity>>

    @Query("SELECT * FROM date_table ORDER BY date DESC LIMIT 1")
    fun getLastDate(): Flow<List<DateEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateDate(date: DateEntity)
}