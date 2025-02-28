package com.czy.learning_lab2.features.account.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AccountIcon(
    iconName: String = "default",
) {
    val icon = when (iconName) {
        "default" -> Icons.Filled.AccountBalance
        "savings" -> Icons.Filled.Savings
        "card" -> Icons.Filled.CreditCard
        else -> Icons.Filled.AccountBalance
    }

    Icon(
        imageVector = icon,
        contentDescription = "Account Icon",
        modifier = Modifier.size(48.dp)
    )
}

@Preview
@Composable
fun AccountIconPreview() {
    Column {
        AccountIcon()
        AccountIcon("savings")
        AccountIcon("card")
    }
}