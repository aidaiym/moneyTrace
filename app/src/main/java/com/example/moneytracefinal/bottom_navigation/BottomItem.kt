package com.example.moneytracefinal.bottom_navigation

import com.example.moneytracefinal.R

sealed class BottomItem(val title: String, val iconId: Int, val route: String){
    object FinancialTransactionScreen: BottomItem("Операции", R.drawable.operation_icon, "FinancialTransactionScreen")
    object CategoryScreen: BottomItem("Категории", R.drawable.category_icon, "CategoryScreen")
    object CreateTransactionScreen: BottomItem("Добавить", R.drawable.create_operation_icon, "CreateTransactionScreen")
}
