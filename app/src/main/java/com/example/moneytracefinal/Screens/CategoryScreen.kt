package com.example.moneytracefinal.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.moneytracefinal.MainViewModel
import com.example.moneytracefinal.R

@Composable
fun CategoryScreen ( navController: NavController, mainViewModel: MainViewModel = viewModel(factory = MainViewModel.factory)){
    val categoryExpenseList = mainViewModel.categoryExpense.collectAsState(initial = emptyList())
    val categoryIncomeList = mainViewModel.categoryIncome.collectAsState(initial = emptyList())


    Column {
        Box(
            modifier = Modifier
                .padding(top = 25.dp, bottom = 15.dp, start = 5.dp, end = 5.dp)
                .clip(shape = RoundedCornerShape(15.dp))
                .fillMaxWidth()
                .background(color = colorResource(R.color.card))


        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, start = 35.dp, end = 30.dp, bottom = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(painter = painterResource(id = R.drawable.baseline_arrow_back_24), contentDescription = "sdfsf")
                Text(text = "Новая категория", color = Color.White, fontSize = 16.sp, modifier = Modifier
                    .clickable { navController.navigate("CreateCategoryScreen") })
            }

        }
        Box(modifier = Modifier
            .padding(top = 25.dp, bottom = 15.dp, start = 5.dp, end = 5.dp)
            .background(color = colorResource(id = R.color.card))){
            Column() {
                Text(text = "Доходы")
                LazyColumn(modifier = Modifier.fillMaxWidth()){
                    items(categoryIncomeList.value){item ->
                        ListItem(item)
                    }
                }
                Text(text = "Расходы")
                LazyColumn(modifier = Modifier.fillMaxWidth()){
                    items(categoryExpenseList.value){item ->
                        ListItem(item)
                    }
                }
            }

        }
    }
}

