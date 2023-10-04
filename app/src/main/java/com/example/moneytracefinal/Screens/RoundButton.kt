package com.example.moneytracefinal.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.moneytracefinal.MainViewModel

@Composable
fun RoundButton(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Color.Green else Color.Gray,
            contentColor = Color.White
        ),
        modifier = Modifier
            .size(64.dp)
            .padding(8.dp)
    ) {
        Text(text = text, fontSize = 16.sp)
    }
}

@Composable
fun TwoRoundButtons(mainViewModel: MainViewModel = viewModel(factory = MainViewModel.factory)){
    var selectedOption1 by remember { mutableStateOf(true) }
    var selectedOption2 by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            RoundButton(
                text = "Доход",
                isSelected = selectedOption1,
                onClick = {
                selectedOption2 = false
                    selectedOption1 = true
                    mainViewModel.newCategoryType.value = "Доход"
                }
            )

            Spacer(modifier = Modifier.width(16.dp))

            RoundButton(
                text = "Расход",
                isSelected = selectedOption2,
                onClick = { selectedOption1 = false
                selectedOption2 = true
                mainViewModel.newCategoryType.value = "Расход"}
            )
        }
    }
}