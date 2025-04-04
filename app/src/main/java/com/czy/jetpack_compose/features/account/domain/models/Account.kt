package com.czy.jetpack_compose.features.account.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Account(
    @SerialName("id")
    val id: String,
    @SerialName("account_number")
    val accountNumber: String,
    @SerialName("account_type")
    val accountType: String = "AHO",
    @SerialName("balance")
    val balance: Double,
    @SerialName("icon")
    val icon: String = "savings"
)