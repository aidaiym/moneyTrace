package com.example.moneytracefinal.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {
    @Query("SELECT * FROM CategoryEntity")
    fun getAllCategories(): Flow<List<CategoryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: CategoryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategories(categories: List<CategoryEntity>)

    @Query("SELECT * FROM CategoryEntity WHERE type = 'Доход'")
    fun getIncome(): Flow<List<CategoryEntity>>

    @Query("SELECT * FROM CategoryEntity WHERE type = 'Расход'")
    fun getExpense(): Flow<List<CategoryEntity>>


}