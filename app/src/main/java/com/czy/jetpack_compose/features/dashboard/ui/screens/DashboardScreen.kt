package com.czy.jetpack_compose.features.dashboard.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.czy.jetpack_compose.features.account.ui.components.account.AccountCard
import com.czy.jetpack_compose.features.dashboard.ui.components.Greetings
import com.czy.jetpack_compose.navigation.NavigationItem
import com.czy.jetpack_compose.ui.theme.Learning_lab2Theme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun DashboardScreen(
    navController: NavController,
    state: DashboardScreenState = DashboardScreenState()
){

    val accountList = state.accounts

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Greetings("CZY")
                }
            )
        },
    ) { innerPadding ->

        LazyColumn {
            item {
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
                                NavigationItem.AccountNavigation.route + "/${account.id}"
                            ) }
                        )
                    }
                }
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