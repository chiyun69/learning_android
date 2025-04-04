package com.czy.jetpack_compose.features.account.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movement (
    @SerialName("id")
    val id: String,
    @SerialName("account_number")
    val accountNumber: String,
    @SerialName("balance")
    val balance: Double,
    @SerialName("amount")
    val amount: Double,
    @SerialName("description")
    val description: String,
    @SerialName("ref1")
    val ref1: String = "",
    @SerialName("ref2")
    val ref2: String = "",
    @SerialName("ref3")
    val ref3: String = ""
)