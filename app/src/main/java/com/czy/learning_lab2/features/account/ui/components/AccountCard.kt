package com.czy.learning_lab2.features.account.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.czy.learning_lab2.features.account.domain.models.Account

@Composable
fun AccountCard(
    account: Account,
    modifier: Modifier = Modifier
){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = modifier
    ) {
        Column(modifier = Modifier.padding(16.dp))  {
            Row(modifier = Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                AccountIcon(iconName = account.icon)

                IconButton(onClick = { /* Handle the click action here */ }) {
                    Icon(Icons.Filled.RemoveRedEye, contentDescription = "Favorite")
                }
            }

            Text(
                text = "$ " + account.balance,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = account.accountType,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun AccountCardPreview(){
    Surface(modifier = Modifier.padding(16.dp)) {
        AccountCard(Account(
            "1",
            "1234567890",
            "Savings",
            1000.00,
            "savings"))
    }
}