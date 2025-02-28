package com.czy.learning_lab2.features.account.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.QrCode2
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.czy.learning_lab2.features.account.domain.models.Account

@Composable
fun AccountHeader(
    account: Account,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.background(MaterialTheme.colorScheme.surfaceVariant)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, top = 16.dp)
        ) {
            AccountIcon(iconName = account.icon)

            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier.padding(top = 18.dp)
            ) {
                Text(
                    text = "$ " + account.balance,
                    fontWeight = FontWeight.Medium,
                    fontSize = 24.sp,
                )
                Text(
                    "Disponible",
                    color = Color.Gray
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(16.dp).fillMaxWidth()
        ) {
            Column {
                Text(
                    text = account.accountNumber,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                )
                Text(
                    text = account.accountType,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 2.dp)
                )
            }
            Row(horizontalArrangement = Arrangement.End) {
                IconButton(onClick = { /* Handle the click action here */ }) {
                    Icon(
                        imageVector = Icons.Outlined.QrCode2,
                        contentDescription = "Account Icon",
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun AccountHeaderPreview(){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        AccountHeader(
            account = Account(
            "1",
            "1234567890",
            "Savings",
            1000.00,
            icon = "savings"
            ), modifier = Modifier.padding(innerPadding)
        )
    }
}