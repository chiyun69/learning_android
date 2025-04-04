package com.czy.jetpack_compose.features.dashboard.ui.screens

import com.czy.jetpack_compose.features.account.domain.models.Account

data class DashboardScreenState(
    val isLoading: Boolean = false,
    val accounts: List<Account> = emptyList(),
)