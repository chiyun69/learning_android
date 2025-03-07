package com.czy.learning_lab2.features.account.ui.components.account

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AccountIcon(
    modifier: Modifier = Modifier,
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
        modifier = modifier.size(36.dp)
    )
}

@Preview
@Composable
fun AccountIconPreview() {
    Surface {
        Column {
            AccountIcon()
            AccountIcon(Modifier,"savings")
            AccountIcon(Modifier,"card")
        }
    }
}