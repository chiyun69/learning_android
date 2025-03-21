package com.czy.jetpack_compose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.sharp.ReceiptLong
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.outlined.AccountBalance
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.ui.graphics.vector.ImageVector

enum class Screen {
    DASHBOARD,
    PAYMENTS,
    MENU,
    CIRCULOS,
    PROFILE,
    ACCOUNT,
}

sealed class MenuItem(var route: String, val icon: ImageVector, var title: String) {
    data object Dashboard : MenuItem(Screen.DASHBOARD.name, Icons.Outlined.AccountBalance, "Resumen")
    data object Payments : MenuItem(Screen.PAYMENTS.name, Icons.AutoMirrored.Sharp.ReceiptLong, "Pagos")
    data object Menu : MenuItem(Screen.MENU.name, Icons.Filled.Apps, "Menu")
    data object Circulos : MenuItem(Screen.CIRCULOS.name, Icons.Outlined.Circle, "Circulos")
    data object Profile : MenuItem(Screen.PROFILE.name, Icons.Outlined.AccountCircle, "Perfil")
}

sealed class NavigationItem(var route: String) {
    data object Account : NavigationItem(Screen.ACCOUNT.name)
}