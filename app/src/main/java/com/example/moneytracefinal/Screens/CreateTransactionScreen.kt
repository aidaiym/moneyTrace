package com.example.moneytracefinal.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.moneytracefinal.MainViewModel
import com.example.moneytracefinal.R
import com.example.moneytracefinal.bottom_navigation.BottomItem
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTransactionScreen(
    navController: NavController,
    mainViewModel: MainViewModel = viewModel(factory = MainViewModel.factory)
) {
    var isError by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Выберите категорию") }
    var catId by remember { mutableLongStateOf(0) }

    val currentDate = remember {
        val dateFormat = SimpleDateFormat("MM.yy", Locale.getDefault())
        dateFormat.format(Date())
    }


    val categoryIncomeList = mainViewModel.categoryIncome.collectAsState(initial = emptyList())
    val categoryExpenseList = mainViewModel.categoryExpense.collectAsState(initial = emptyList())
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
                    contentDescription = "sdfsf", modifier = Modifier.clickable(indication = null,
                        interactionSource = remember { MutableInteractionSource() }) {
//                        navController.navigate(
//                            "CategoryScreen"
//                        )
                    },
                    tint = Color.White
                )
                Text(
                    text = "Сохранить", color = Color.White, fontSize = 16.sp, modifier = Modifier
                        .clickable {
                            if(!isError){
                                navController.navigate("FinancialTransactionScreen")
                                mainViewModel.insertTransaction(currentDate)
                            }

                        }


                )
            }

        }
        Box(
            modifier = Modifier
                .padding(top = 25.dp, bottom = 15.dp, start = 5.dp, end = 5.dp)
                .background(color = colorResource(id = R.color.card).copy(0.5f)),
            contentAlignment = Alignment.Center
        ) {
            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                TextField(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    value = mainViewModel.newTransactionStr.value,
                    onValueChange = {
                        mainViewModel.newTransactionStr.value = it
                        isError = false
                    },
                    label = { Text(text = "введите сумму") },
                    isError = isError,

                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = colorResource(id = R.color.card).copy(0f),
                        focusedIndicatorColor = colorResource(id = R.color.purple_str),
                        unfocusedIndicatorColor = colorResource(id = R.color.purple_str),
                        unfocusedLabelColor = Color.White,
                        textColor = colorResource(id = R.color.white),
                        cursorColor = colorResource(id = R.color.white),
                        focusedLabelColor = colorResource(id = R.color.purple_str)
                    ),
                )

                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        BasicTextField(
                            value = TextFieldValue(
                                selectedOption,
                                selection = TextRange(selectedOption.length)
                            ),
                            readOnly = true,
                            onValueChange = {
                                selectedOption = it.text
                            },

                            modifier = Modifier
                                .weight(1f)
                                .padding(16.dp)
                        )

                        IconButton(
                            onClick = { expanded = true },
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = null
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .padding(start = 5.dp, end = 5.dp)
                            .widthIn(max = 240.dp)
                            .verticalScroll(rememberScrollState())
                            .fillMaxWidth()

                    ) {
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                            modifier = Modifier
                                .height(240.dp) // Установите максимальную высоту меню
                        ) {
                            Text(text = "Доход")
                            categoryIncomeList.value.forEach { option ->
                                DropdownMenuItem(onClick = {
                                    selectedOption = option.name
                                    expanded = false
                                    mainViewModel.catTransaction.longValue = option.id
                                }, text = { Text(text = option.name)})
                            }
                            Text(text = "Расход")
                            categoryExpenseList.value.forEach { option ->
                                DropdownMenuItem(onClick = {
                                    selectedOption = option.name
                                    expanded = false
                                    catId = option.id
                                }, text = { Text(text = option.name)})
                            }
                        }
                    }
                }
                TextField(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    value = mainViewModel.description.value,
                    onValueChange = {
                        mainViewModel.description.value = it
                        isError = false
                    },
                    label = { Text(text = "заметки") },
                    isError = isError,

                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = colorResource(id = R.color.card).copy(0f),
                        focusedIndicatorColor = colorResource(id = R.color.purple_str),
                        unfocusedIndicatorColor = colorResource(id = R.color.purple_str),
                        unfocusedLabelColor = Color.White,
                        textColor = colorResource(id = R.color.white),
                        cursorColor = colorResource(id = R.color.white),
                        focusedLabelColor = colorResource(id = R.color.purple_str)
                    ),
                )
            }


        }
    }

}


