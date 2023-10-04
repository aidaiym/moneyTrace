package com.example.moneytracefinal.Screens

import android.content.SharedPreferences
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.moneytracefinal.MainViewModel
import com.example.moneytracefinal.R
import kotlinx.coroutines.launch

@Composable
fun FinancialTransactionScreen(
               mainViewModel: MainViewModel = viewModel(factory = MainViewModel.factory
               )
) {
    val balanceList = mainViewModel.balance.collectAsState(initial = emptyList())

    val balance = balanceList.value.firstOrNull()?.balance ?: 0


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
                Column {
                    Text(text = "Баланс", color = Color.White, fontSize = 16.sp)
                    Text(
                        text = balance.toString(),
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Text(text = "Изменить остаток", color = Color.White, fontSize = 16.sp)
            }
        }
        TabLayout()
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabLayout() {
    Log.d("MyLog", "1")
    val tabList = listOf("В этом месяце", "Планы на будущее")
    val state = rememberPagerState(initialPage = 0, pageCount = { 2 })
    val tabIndex = state.currentPage
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .clip(RoundedCornerShape(15.dp)),
    ) {
//        TabRow(
//            selectedTabIndex = tabIndex,
//            containerColor = Color.LightGray,
//
//            ) {
//
//            tabList.forEachIndexed { index, text ->
//                val isSelected = index == tabIndex
//                val backgroundColor = if (isSelected) Color.White else Color.LightGray
//
//
//                Tab( selected = state.currentPage == index,
//                    onClick = {
//                        coroutineScope.launch {
//                            state.animateScrollToPage(index)
//                        }
//                    },
//                    text = {
//                            Text(
//                                text = text,
//                                maxLines = 2, overflow = TextOverflow.Ellipsis, color = Color.Black,
//                                style = TextStyle(Color.LightGray),
//                                fontSize = 14.sp,
//
//                                )
//
//                    }
//
//                )
//
//            }
//        }

        HorizontalPager(
            state = state,
            beyondBoundsPageCount = 2,
            modifier = Modifier.fillMaxWidth()
        )
        { page ->
            val list = when (page) {
                0 -> "dfgd"
                1 -> "fdgdfg"
                else -> "dfgdfg"
            }
        }

    }

    Row(
        modifier = Modifier
            .padding(start = 5.dp, end = 5.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(color = colorResource(id = R.color.gray_5)),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        tabList.forEachIndexed { index, text ->
            Box(
                modifier = Modifier
                    .height(60.dp)
                    .width(200.dp)
                    .padding(top = 5.dp, bottom = 5.dp, start = 5.dp, end = 5.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(
                        color = if (tabIndex == index) Color.White else colorResource(id = R.color.gray_5)
                    )
                    .clickable { coroutineScope.launch { state.scrollToPage(index) } },
                Alignment.Center
            ) {
                Text(text = text, color =  if (tabIndex == index) colorResource(id = R.color.purple_str) else Color.LightGray, modifier = Modifier.padding(8.dp))
            }
        }
    }
}