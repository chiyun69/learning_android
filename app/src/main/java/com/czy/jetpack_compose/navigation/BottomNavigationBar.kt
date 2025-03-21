package com.czy.jetpack_compose.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.rememberNavController
import com.czy.jetpack_compose.ui.theme.Learning_lab2Theme

@Composable
fun BottomNavigationBar(navController: NavController, items: List<MenuItem>, openMenuSheet: () -> Unit) {

    var selectedItem by remember { mutableIntStateOf(0) }
    var currentRoute by remember { mutableStateOf(MenuItem.Dashboard.route) }

    items.forEachIndexed { index, navigationItem ->
        if (navigationItem.route == currentRoute) {
            selectedItem = index
        }
    }

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                modifier = Modifier.alignByBaseline(),
                alwaysShowLabel = true,
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
                                imageVector = item.icon,
                                contentDescription = item.title,
                                tint = Color.White
                            )
                        }
                    } else {
                        Icon(item.icon, contentDescription = item.title)
                    }
                },
                label = { Text(item.title, fontSize = MaterialTheme.typography.labelSmall.fontSize) },
                selected = selectedItem == index,
                colors = NavigationBarItemColors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor =  MaterialTheme.colorScheme.primary,
                    selectedIndicatorColor =  Color.Transparent,
                    unselectedIconColor =  MaterialTheme.colorScheme.secondary,
                    unselectedTextColor =  MaterialTheme.colorScheme.secondary,
                    disabledIconColor =  Color.Gray,
                    disabledTextColor = Color.Gray
                ),
                onClick = {
                    if (index == 2) {
                        openMenuSheet()
                    } else {
                        selectedItem = index
                        currentRoute = item.route
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}

@Preview
@Composable
fun BottomNavigationBarPreview() {
    val bottomNavItems = listOf(
        MenuItem.Dashboard,
        MenuItem.Payments,
        MenuItem.Menu,
        MenuItem.Circulos,
        MenuItem.Profile,
    )
    Learning_lab2Theme {
        val navController = rememberNavController()
        navController.navigatorProvider.addNavigator(ComposeNavigator())
        BottomNavigationBar(navController = navController, bottomNavItems, openMenuSheet = {})
    }
}