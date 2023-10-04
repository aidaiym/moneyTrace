package com.example.moneytracefinal.bottom_navigation

import androidx.compose.foundation.background
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.moneytracefinal.R

@Composable
fun BottomNavigation(
    navController: NavController
) {
    val listItems = listOf(
        BottomItem.FinancialTransactionScreen,
        BottomItem.CreateTransactionScreen,
        BottomItem.CategoryScreen
    )
    NavigationBar (
        modifier = Modifier,
        containerColor = colorResource(id = R.color.white)
    ){
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRout = backStackEntry?.destination?.route
        listItems.forEach{item ->
            NavigationBarItem(
                selected = currentRout == item.route,
                onClick = {
                    navController.navigate(item.route)
                },
                icon = {
                    Icon(painter = painterResource(id = item.iconId), contentDescription = "")
                },

                label = {

                    Text(text = item.title, fontSize = 9.sp)

                },

            )

        }
    }
}