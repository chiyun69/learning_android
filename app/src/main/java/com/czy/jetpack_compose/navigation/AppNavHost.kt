package com.czy.jetpack_compose.navigation

import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.czy.jetpack_compose.features.account.ui.screens.AccountScreen
import com.czy.jetpack_compose.features.account.ui.screens.AccountScreenViewModel
import com.czy.jetpack_compose.features.dashboard.ui.screens.DashboardScreen
import com.czy.jetpack_compose.features.dashboard.ui.screens.DashboardScreenViewModel

@Composable
fun AppNavHost(navController: NavHostController) {


    val slideInAnim = slideInHorizontally(
        initialOffsetX = { fullWidth -> fullWidth },
        animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)
    )
    val fadeInAnim = fadeIn(
        initialAlpha = 0f,
        animationSpec = tween(durationMillis = 500, easing = EaseOut)
    )
    val fadeOutAnim = fadeOut(animationSpec = tween(durationMillis = 300))

    val animViewEnter = fadeInAnim.plus(slideInAnim)

    NavHost(
        navController,
        startDestination = MenuItem.Dashboard.route
    ) {
        composable(
            route = MenuItem.Dashboard.route,
            enterTransition = { slideInHorizontally() },
            exitTransition = { fadeOutAnim }
        ) {
            val viewModel = hiltViewModel<DashboardScreenViewModel>()
            val state by viewModel.state.collectAsStateWithLifecycle()
            DashboardScreen(navController, state)
        }
        composable(
            route = MenuItem.Payments.route,
            enterTransition = { slideInHorizontally() },
            exitTransition = { fadeOutAnim }
        ) {
            PaymentsScreen()
        }

        composable(
            route = MenuItem.Circulos.route,
            enterTransition = { slideInHorizontally() },
            exitTransition = { fadeOutAnim }
        ) {
            CirculosScreen()
        }
        composable(
            route = MenuItem.Profile.route,
            enterTransition = { slideInHorizontally() },
            exitTransition = { fadeOutAnim }
        ) {
            ProfileScreen()
        }

        composable(
            route = NavigationItem.AccountNavigation.route + "/{accountId}",
            enterTransition = { animViewEnter },
            exitTransition = { fadeOutAnim }
        ) {
            val accountId = it.arguments?.getString("accountId") ?: ""
            val viewModel = hiltViewModel<AccountScreenViewModel>()
            val state by viewModel.state.collectAsStateWithLifecycle()

            AccountScreen(navController, accountId, state)
        }
    }
}

@Composable
fun PaymentsScreen() {
    CenterText(text = "Pagos")
}

@Composable
fun CirculosScreen() {
    CenterText(text = "Circulos")
}

@Composable
fun ProfileScreen() {
    CenterText(text = "Perfil")
}

@Composable
fun CenterText(text: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = text, fontSize = 32.sp)
    }
}