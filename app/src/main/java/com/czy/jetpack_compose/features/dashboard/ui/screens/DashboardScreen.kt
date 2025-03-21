package com.czy.jetpack_compose.features.dashboard.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.rememberNavController
import com.czy.jetpack_compose.features.account.domain.models.Account
import com.czy.jetpack_compose.features.account.ui.components.account.AccountCard
import com.czy.jetpack_compose.features.dashboard.ui.components.Greetings
import com.czy.jetpack_compose.navigation.NavigationItem
import com.czy.jetpack_compose.ui.theme.Learning_lab2Theme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun DashboardScreen(navController: NavController){

    val accountList = listOf(
        Account(id = "1", accountNumber = "1234567890", balance = 10000.00),
        Account(id = "2", accountNumber = "9876543210", balance = 5000.00),
        Account(id = "3", accountNumber = "4567890123", balance = 2500.00),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Greetings("CZY")
                }
            )
        },
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
                    onClick = { navController.navigate(
                        NavigationItem.Account.route + "/${account.id}"
                    ) }
                )
            }
        }

    }
}

@Preview
@Composable
fun DashboardScreenPreview() {
    Learning_lab2Theme {
        val navController = rememberNavController()
        navController.navigatorProvider.addNavigator(ComposeNavigator())
        DashboardScreen(navController = navController)
    }
}