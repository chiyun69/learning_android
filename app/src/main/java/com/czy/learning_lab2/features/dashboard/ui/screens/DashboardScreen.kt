package com.czy.learning_lab2.features.dashboard.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.sharp.ReceiptLong
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material.icons.sharp.AccountBalance
import androidx.compose.material.icons.sharp.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.czy.learning_lab2.features.account.domain.models.Account
import com.czy.learning_lab2.features.account.ui.components.account.AccountCard
import com.czy.learning_lab2.features.dashboard.ui.components.Greetings

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun DashboardScreen(){
    val accountList = listOf(
        Account(id = "1", accountNumber = "1234567890", balance = 10000.00),
        Account(id = "2", accountNumber = "9876543210", balance = 5000.00),
        Account(id = "3", accountNumber = "4567890123", balance = 2500.00),
    )

    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabItems = listOf(
        TabItem("Resumen", Icons.Sharp.AccountBalance),
        TabItem("Pagos", Icons.AutoMirrored.Sharp.ReceiptLong),
        TabItem("Menu", Icons.Filled.Apps),
        TabItem("Circulos", Icons.Outlined.Circle),
        TabItem("Perfil", Icons.Sharp.AccountCircle)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Greetings("CZY")
                }
            )
        },
        bottomBar = {
            TabRow(selectedTabIndex = selectedTabIndex) {
                tabItems.forEachIndexed { index, tabItem ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = { Text(tabItem.title,
                            fontSize = MaterialTheme.typography.labelSmall.fontSize) },
                        icon = {
                            if (index == 2) {
                                Box(
                                    modifier = Modifier
                                        .size(42.dp)
                                        .clip(CircleShape)
                                        .background(MaterialTheme.colorScheme.primary),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = tabItem.icon,
                                        contentDescription = tabItem.title,
                                        tint = Color.White
                                    )
                                }
                            } else {
                                Icon(
                                    imageVector = tabItem.icon,
                                    contentDescription = tabItem.title
                                )
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->

        FlowRow(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 8.dp),

            horizontalArrangement = Arrangement.spacedBy(4.dp),
            maxItemsInEachRow = 2
        ) {
            val itemModifier = Modifier
                .weight(1.0f)
                .padding(4.dp)

            accountList.forEach { account ->
                AccountCard(
                    modifier = itemModifier,
                    account = account,
                )
            }
        }

    }
}

data class TabItem(val title: String, val icon: ImageVector)


@Preview
@Composable
fun DashboardScreenPreview() {
    DashboardScreen()
}