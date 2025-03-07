package com.czy.learning_lab2.features.account.ui.components.account

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.czy.learning_lab2.features.dashboard.ui.screens.DashboardScreenPreview

@Composable
fun AccountCard(
    modifier: Modifier = Modifier,
    account: Account,
){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier
    ) {
        Column(modifier = Modifier.padding(16.dp))  {
            Row(modifier = Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween) {

                AccountIcon(iconName = account.icon)

                IconButton(onClick = { /* Handle the click action here */ }, modifier = Modifier.size(24.dp)) {
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
                text = account.accountType + " " + account.accountNumber.take(0) + "XXXX" + account.accountNumber.takeLast(4),
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
        AccountCard(Modifier, Account(
            "1",
            "1234567890",
            "AHO",
            1000.00,
            "savings"))
    }
}

@Preview(showBackground = true)
@Composable
fun AccountCardPreview2(){
    DashboardScreenPreview()
}