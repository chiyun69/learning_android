package com.czy.jetpack_compose.features.account.domain.models

data class Account(
    val id: String,
    val accountNumber: String,
    val accountType: String = "AHO",
    val balance: Double,
    val icon: String = "savings"
)