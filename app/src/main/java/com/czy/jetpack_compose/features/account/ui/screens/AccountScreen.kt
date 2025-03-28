package com.czy.jetpack_compose.features.account.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.rememberNavController
import com.czy.jetpack_compose.features.account.domain.models.Account
import com.czy.jetpack_compose.features.account.domain.models.Movement
import com.czy.jetpack_compose.features.account.ui.components.account.AccountHeader
import com.czy.jetpack_compose.features.account.ui.components.movement.AccountMovementList
import com.czy.jetpack_compose.ui.theme.Learning_lab2Theme

@Composable
fun AccountScreen(navController: NavController, accountId: String = "") {

    // Dummy data
    val accountList = listOf(
        Account(id = "1", accountNumber = "1234567890", balance = 10000.00),
        Account(id = "2", accountNumber = "9876543210", balance = 5000.00),
        Account(id = "3", accountNumber = "4567890123", balance = 2500.00),
    )
    val movementList = listOf(
        Movement(
            "1",
            "1234567890",
            1000.00,
            200.00,
            "Transferencia Directa",
            "Referencia 1",
        ),
        Movement(
            "2",
            "1234567890",
            1000.00,
            200.00,
            "Pago de servicio",
            "Referencia 1",
            "Referencia 2",
            "Referencia 3"
        ),
        Movement(
            "3",
            "1234567890",
            1000.00,
            200.00,
            "Deposito en efectivo",
            "Referencia 1",
            "Referencia 2",
        ),
        Movement(
            "1",
            "1234567890",
            1000.00,
            200.00,
            "Transferencia Directa",
            "Referencia 1",
            "Referencia 2",
        ),
        Movement(
            "2",
            "1234567890",
            1000.00,
            200.00,
            "Pago de servicio",
            "Referencia 1",
        ),
        Movement(
            "3",
            "1234567890",
            1000.00,
            200.00,
            "Deposito en efectivo",
            "Referencia 1",
        ),
        Movement(
            "1",
            "1234567890",
            1000.00,
            200.00,
            "Transferencia Directa",
            "Referencia 1",
            "Referencia 2",
        ),
        Movement(
            "2",
            "1234567890",
            1000.00,
            200.00,
            "Pago de servicio",
            "Referencia 1",
            "Referencia 2",
            "Referencia 3"
        ),
        Movement(
            "3",
            "1234567890",
            1000.00,
            200.00,
            "Deposito en efectivo",
            "Referencia 1",
            "Referencia 2",
        ),
        Movement(
            "1",
            "1234567890",
            1000.00,
            200.00,
            "Transferencia Directa",
            "Referencia 1",
        ),
        Movement(
            "2",
            "1234567890",
            1000.00,
            200.00,
            "Pago de servicio",
            "Referencia 1",
            "Referencia 2",
            "Referencia 3"
        ),
        Movement(
            "3",
            "1234567890",
            1000.00,
            200.00,
            "Deposito en efectivo",
            "Referencia 1",
            "Referencia 2",
        ),
        Movement(
            "1",
            "1234567890",
            1000.00,
            200.00,
            "Transferencia Directa",
            "Referencia 1",
            "Referencia 2",
        ),
        Movement(
            "2",
            "1234567890",
            1000.00,
            200.00,
            "Pago de servicio",
            "Referencia 1",
        ),
        Movement(
            "3",
            "1234567890",
            1000.00,
            200.00,
            "Deposito en efectivo",
            "Referencia 1",
        ),
        Movement(
            "1",
            "1234567890",
            1000.00,
            200.00,
            "Transferencia Directa",
            "Referencia 1",
            "Referencia 2",
        ),
        Movement(
            "2",
            "1234567890",
            1000.00,
            200.00,
            "Pago de servicio",
            "Referencia 1",
            "Referencia 2",
            "Referencia 3"
        ),
        Movement(
            "3",
            "1234567890",
            1000.00,
            200.00,
            "Deposito en efectivo",
            "Referencia 1",
            "Referencia 2",
        ),
    )

    val listState = rememberLazyListState()
    val isHeaderVisible by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex == 1 && listState.firstVisibleItemScrollOffset >= 0
        }
    }

    fun getAccountById(accountId: String): Account? {
        return accountList.find { it.id == accountId }
    }
    val account = getAccountById(accountId)

    if (account == null) {
       navController.popBackStack()
        return
    }

    Scaffold(
        topBar = {
            AccountStickyHeader(navController = navController, account, isHeaderVisible)
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            state = listState
        ) {
            item {
                AccountHeader(Modifier, account)
            }

            item {
                AccountMovementList(
                    movementList = movementList,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountStickyHeader(navController: NavController, account: Account , isHeaderVisible: Boolean) {
    TopAppBar(
        title = {
            if (isHeaderVisible) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(text = account.accountNumber,
                        fontSize = 16.sp)
                    Text("$ ${account.balance}")
                }
            }
        },
        navigationIcon = {
            if (navController.previousBackStackEntry != null) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White
        )
    )
}

@Preview
@Composable
fun AccountScreenPreview() {
    Learning_lab2Theme {
        val navController = rememberNavController()
        navController.navigatorProvider.addNavigator(ComposeNavigator())
        AccountScreen(navController = navController, accountId = "1")
    }
}


@Preview
@Composable
fun AccountScreenPreview2() {
    Learning_lab2Theme {
        val navController = rememberNavController()
        navController.navigatorProvider.addNavigator(ComposeNavigator())
        val account = Account(id = "1", accountNumber = "1234567890", balance = 10000.00)
        Surface {
            AccountStickyHeader(navController, account, true)
        }
    }
}