package com.czy.learning_lab2.features.account.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.czy.learning_lab2.features.account.domain.models.Account
import com.czy.learning_lab2.features.account.ui.components.account.AccountHeader
import com.czy.learning_lab2.features.account.ui.components.movement.AccountMovements

@Composable
fun AccountScreen(account: Account) {
    Scaffold(

    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            AccountHeader(Modifier, account)

            repeat(20) {
                AccountMovements(modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp))
            }
        }
    }
}


@Preview
@Composable
fun AccountScreenPreview() {
    AccountScreen(Account(id = "1", accountNumber = "1234567890", balance = 10000.00))
}