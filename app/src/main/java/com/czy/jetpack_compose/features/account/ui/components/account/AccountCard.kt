package com.czy.jetpack_compose.features.account.ui.components.account

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.czy.jetpack_compose.features.account.domain.models.Account
import com.czy.jetpack_compose.features.dashboard.ui.screens.DashboardScreenPreview
import com.czy.jetpack_compose.ui.theme.Learning_lab2Theme

@Composable
fun AccountCard(
    modifier: Modifier = Modifier,
    account: Account,
    onClick: () -> Unit = {}
){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier,
        onClick = onClick
    ) {
        Column(modifier = Modifier.padding(16.dp))  {
            Row(modifier = Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween) {

                AccountIcon(iconName = account.icon)

                IconButton(onClick = { /* Handle the click action here */ }, modifier = Modifier.size(24.dp)) {
                    Box(modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Filled.RemoveRedEye, contentDescription = "Favorite", modifier = Modifier.padding(4.dp))
                    }

                }
            }

            Text(
                text = "$ " + account.balance,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )
            Text(
                text = account.accountType + " " + account.accountNumber.take(0) + "XXXX" + account.accountNumber.takeLast(4),
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Normal
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun AccountCardPreview() {
    Learning_lab2Theme {
        Surface(modifier = Modifier.padding(16.dp)) {
            AccountCard(
                Modifier, Account(
                    "1",
                    "1234567890",
                    "AHO",
                    1000.00,
                    "savings"
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AccountCardPreview2(){
    DashboardScreenPreview()
}