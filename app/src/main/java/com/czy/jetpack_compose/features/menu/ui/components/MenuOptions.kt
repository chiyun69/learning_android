package com.czy.jetpack_compose.features.menu.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.SendToMobile
import androidx.compose.material.icons.outlined.MonetizationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.rememberNavController
import com.czy.jetpack_compose.ui.theme.Learning_lab2Theme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MenuOptions() {
    // Sheet content
    FlowRow(
        modifier = Modifier
            .padding(horizontal = 8.dp),

        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            colors = ButtonDefaults.filledTonalButtonColors(),
            modifier = Modifier.padding(12.dp),
            onClick = { }) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Icon(imageVector = Icons.AutoMirrored.Outlined.SendToMobile, contentDescription = "Money")
                Text("Transferir", fontSize = MaterialTheme.typography.labelLarge.fontSize)
            }
        }

        Button(
            colors = ButtonDefaults.filledTonalButtonColors(),
            modifier = Modifier.padding(12.dp),
            onClick = { }) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Icon(imageVector = Icons.Outlined.MonetizationOn, contentDescription = "Money")
                Text("Efectivo Móvil", fontSize = MaterialTheme.typography.labelLarge.fontSize)
            }
        }
    }
}

@Preview
@Composable
fun MenuOptionsPreview() {
    Learning_lab2Theme {
        val navController = rememberNavController()
        navController.navigatorProvider.addNavigator(ComposeNavigator())
        Surface {
            MenuOptions()
        }
    }
}