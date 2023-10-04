package com.example.moneytracefinal

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.moneytracefinal.data.BalanceEntity
import com.example.moneytracefinal.data.CategoryEntity

import com.example.moneytracefinal.data.MainDb
import kotlinx.coroutines.launch


class MainViewModel(val database: MainDb): ViewModel() {

    val category = database.categoryDao.getAllCategories()

    val categoryIncome = database.categoryDao.getIncome()
    val categoryExpense = database.categoryDao.getExpense()

    val balance = database.balanceDao.getBalance()
    var balanceEntity: BalanceEntity? = null
    var number:Long = 0
    val newBalance = mutableStateOf(number)

    fun insertBalance() = viewModelScope.launch {
        Log.d("MyLog", "dfsdf")
        Log.d("MyLog", "$newBalance")

        val balanceItem = balanceEntity?.copy(balance = newBalance.value) ?: BalanceEntity(balance = newBalance.value)
        Log.d("MyLog", "$balanceItem")
        database.balanceDao.updateBalance(balanceItem)

        Log.d("MyLog", "4")
        balanceEntity = null
        newBalance.value = number




        Log.d("MyLog", "dfsdf")

    }


    fun insertDefaultCategory() = viewModelScope.launch {
        val defaultCategory = listOf(
            CategoryEntity(name = "Зарплата", type = "Доход"),
            CategoryEntity(name = "Бизнес", type = "Доход"),
            CategoryEntity(name = "Аренда", type = "Доход"),
            CategoryEntity(name = "Подарки", type = "Доход"),
            CategoryEntity(name = "Аренда", type = "Расход"),
            CategoryEntity(name = "Коммунальные услуги", type = "Расход"),
            CategoryEntity(name = "Питание", type = "Расход"),
            CategoryEntity(name = "Транспорт", type = "Расход")
        )
        database.categoryDao.insertCategories(defaultCategory)
    }

    companion object{
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory{
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>, extras: CreationExtras): T {
                val database = (checkNotNull(extras[APPLICATION_KEY]) as MyApp).database
                return MainViewModel(database) as T
            }
        }
    }
}