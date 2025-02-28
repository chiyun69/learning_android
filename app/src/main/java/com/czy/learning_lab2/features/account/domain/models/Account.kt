package com.czy.learning_lab2.features.account.domain.models

data class Account(
    val id: String,
    val accountNumber: String,
    val accountType: String,
    val balance: Double,
    val icon: String
)