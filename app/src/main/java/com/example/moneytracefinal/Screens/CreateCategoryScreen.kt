package com.example.moneytracefinal.Screens

import android.widget.EditText
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.moneytracefinal.MainViewModel
import com.example.moneytracefinal.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateCategoryScreen(navController: NavController, mainViewModel: MainViewModel = viewModel(factory = MainViewModel.factory)) {
    var isError by remember { mutableStateOf(false) }
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
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                    contentDescription = "sdfsf"
                )
                Text(
                    text = "Сохранить", color = Color.White, fontSize = 16.sp, modifier = Modifier
                    .clickable {
                        //navController.navigate("CreateCategoryScreen")
                        isError = mainViewModel.newCategoryName.value == ""
                        mainViewModel.insertCategory()
                        }


                )
            }

        }
        Box(modifier = Modifier
            .padding(top = 25.dp, bottom = 15.dp, start = 5.dp, end = 5.dp)
            .background(color = colorResource(id = R.color.card))) {
            Column {
                TextField(modifier = Modifier.fillMaxWidth(), value = mainViewModel.newCategoryName.value, onValueChange = {
                    mainViewModel.newCategoryName.value = it
                    isError = false
                }, isError = isError)
                if (isError) {
                    Text(
                        text = "Вы не заполнили поле!",
                        color = Color.Red,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                TwoRoundButtons()

            }


    }
    }


}


