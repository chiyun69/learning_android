package com.czy.jetpack_compose.features.account.ui.screens

import com.czy.jetpack_compose.features.account.domain.models.Movement

data class AccountScreenState (
    val isLoading: Boolean = false,
    val movements: List<Movement> = emptyList(),
)