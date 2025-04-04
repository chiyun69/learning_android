package com.czy.jetpack_compose.features.dashboard.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.czy.jetpack_compose.features.account.domain.repository.AccountRepository
import com.skydoves.sandwich.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardScreenViewModel @Inject constructor(
    private val accountRepository: AccountRepository,
): ViewModel() {

    private val _state = MutableStateFlow(DashboardScreenState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            accountRepository.getAccounts()
                .onSuccess {
                    _state.update {
                        it.copy(
                            accounts = data,
                        )
                    }
                }

        }

    }
}