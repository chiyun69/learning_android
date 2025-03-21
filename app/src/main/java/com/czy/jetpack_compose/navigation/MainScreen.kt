package com.czy.jetpack_compose.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.czy.jetpack_compose.features.menu.ui.components.MenuSheet
import com.czy.jetpack_compose.ui.theme.Learning_lab2Theme

@Composable
fun MainScreen(
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    var showMenuSheet by remember { mutableStateOf(false) }

    val bottomNavItems = listOf(
        MenuItem.Dashboard,
        MenuItem.Payments,
        MenuItem.Menu,
        MenuItem.Circulos,
        MenuItem.Profile,
    )

    val showBottomBar = currentDestination?.route in bottomNavItems.map { it.route }

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomAppBar(modifier = Modifier, containerColor = MaterialTheme.colorScheme.background) {
                    BottomNavigationBar(
                        navController = navController,
                        items = bottomNavItems,
                        openMenuSheet = {
                            showMenuSheet = true
                    })
                }
            }
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(
                PaddingValues(
                    0.dp,
                    0.dp,
                    0.dp,
                    innerPadding.calculateBottomPadding()
                )
            )
        ) {
            AppNavHost(navController = navController)
        }

        if (showMenuSheet) {
            MenuSheet(navController, toggleMenuSheet = { showMenuSheet = it })
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    Learning_lab2Theme {
        val navController = rememberNavController()
        navController.navigatorProvider.addNavigator(ComposeNavigator())
        MainScreen(navController = navController)
    }
}