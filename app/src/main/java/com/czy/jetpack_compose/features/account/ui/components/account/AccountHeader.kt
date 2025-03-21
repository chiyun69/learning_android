package com.czy.jetpack_compose.features.account.ui.components.account

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.QrCode2
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.czy.jetpack_compose.features.account.domain.models.Account
import com.czy.jetpack_compose.ui.theme.Learning_lab2Theme

@Composable
fun AccountHeader(
    modifier: Modifier = Modifier,
    account: Account,
) {
    Column(
        modifier = modifier.background(MaterialTheme.colorScheme.primary)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, top = 16.dp)
        ) {
            Box(modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f))
                .size(64.dp),
                contentAlignment = Alignment.Center
            ) {
                AccountIcon(modifier = Modifier.size(46.dp), iconName = account.icon)
            }

            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier.padding(top = 18.dp)
            ) {
                Text(
                    text = "$ " + account.balance,
                    fontWeight = FontWeight.Medium,
                    fontSize = 24.sp,
                    color = Color.White
                )
                Text(
                    "Disponible",
                    color = Color.White
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .fillMaxWidth()
                .padding(top = 4.dp)
        ) {
            Column {
                Text(
                    text = account.accountNumber,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = Color.White
                )
                Text(
                    text = account.accountType,
                    color = Color.White,
                    modifier = Modifier.padding(top = 2.dp)
                )
            }
            Row(horizontalArrangement = Arrangement.End) {
                IconButton(onClick = { /* Handle the click action here */ }) {
                    Icon(
                        imageVector = Icons.Outlined.QrCode2,
                        contentDescription = "Account Icon",
                        modifier = Modifier.size(32.dp),
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun AccountHeaderPreview(){
    Learning_lab2Theme {
        Surface {
            AccountHeader(
                account = Account(
                    "1",
                    "1234567890",
                    "Savings",
                    1000.00,
                    icon = "savings"
                )
            )
        }
    }
}