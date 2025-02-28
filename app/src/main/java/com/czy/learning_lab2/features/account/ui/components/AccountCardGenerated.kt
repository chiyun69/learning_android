package com.czy.learning_lab2.features.account.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AccountCardGenerated(
    accountIcon: ImageVector,
    accountNumber: String,
    accountBalance: String,
    modifier: Modifier = Modifier
) {
    var isAccountNumberVisible by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = accountIcon,
                    contentDescription = "Account Icon",
                    modifier = Modifier.size(48.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = "Account Number",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = if (isAccountNumberVisible) accountNumber else maskAccountNumber(
                            accountNumber
                        ),
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                        modifier = Modifier.clickable {
                            isAccountNumberVisible = !isAccountNumberVisible
                        }
                    )
                }
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "Balance",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = accountBalance,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = { isAccountNumberVisible = !isAccountNumberVisible }) {
                Icon(
                    imageVector = if (isAccountNumberVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                    contentDescription = if (isAccountNumberVisible) "Hide Account Number" else "Show Account Number"
                )
            }
        }
    }
}

fun maskAccountNumber(accountNumber: String): String {
    if (accountNumber.length <= 4) {
        return accountNumber
    }
    val visibleDigits = 4
    val maskedPart = "*".repeat(accountNumber.length - visibleDigits)
    val lastDigits = accountNumber.takeLast(visibleDigits)
    return "$maskedPart$lastDigits"
}

@Preview(showBackground = true)
@Composable
fun AccountCardGeneratedPreview() {
    AccountCardGenerated(
        accountIcon = Icons.Filled.AccountBalance,
        accountNumber = "1234567890123456",
        accountBalance = "$10,000.00"
    )
}