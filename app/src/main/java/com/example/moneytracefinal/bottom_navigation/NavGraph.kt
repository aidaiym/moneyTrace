package com.example.moneytracefinal.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moneytracefinal.Screens.CategoryScreen
import com.example.moneytracefinal.Screens.CreateCategoryScreen
import com.example.moneytracefinal.Screens.CreateTransactionScreen
import com.example.moneytracefinal.Screens.FinancialTransactionScreen

@Composable
fun NavGraph(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = "FinancialTransactionScreen"){
        composable("FinancialTransactionScreen"){
            FinancialTransactionScreen()
        }
        composable("CreateTransactionScreen"){
            CreateTransactionScreen()
        }
        composable("CategoryScreen"){
            CategoryScreen(navController = navHostController)
        }
        composable("CreateCategoryScreen"){
            CreateCategoryScreen(navController = navHostController)
        }
    }
}


