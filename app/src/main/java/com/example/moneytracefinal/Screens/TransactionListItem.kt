package com.example.moneytracefinal.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.moneytracefinal.R
import com.example.moneytracefinal.data.CategoryEntity
import com.example.moneytracefinal.data.FinancialTransactions

@Composable
fun TransactionListItem(item: FinancialTransactions) {
    Box(modifier = Modifier

        .fillMaxWidth()
        .background(color = colorResource(id = R.color.white))
        .padding(end = 10.dp, start = 10.dp, top = 5.dp, bottom = 5.dp)
    ) {
        Text(text = item.summa.toString())
    }
}