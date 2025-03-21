package com.czy.jetpack_compose.features.account.domain.models

data class Movement (
    val id: String,
    val accountNumber: String,
    val balance: Double,
    val amount: Double,
    val description: String,
    val ref1: String = "",
    val ref2: String = "",
    val ref3: String = ""
)