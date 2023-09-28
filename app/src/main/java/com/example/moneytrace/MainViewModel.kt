package com.example.moneytrace

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moneytrace.data.database.Balance
import com.example.moneytrace.data.database.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val repository: Repository by locateLazy()

    val balance = repository.getBalance().asLiveDataFlow()

    fun saveBalance(balance: Long) {
        viewModelScope.launch { repository.updateBalance(createBalance(balance)) }
    }

    private fun createBalance(balance: Long) = Balance(
        balance = balance
    )

    fun <T> Flow<T>.asLiveDataFlow() = shareIn(viewModelScope, SharingStarted.Eagerly, replay = 1)
}