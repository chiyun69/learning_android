package com.czy.jetpack_compose.features.menu.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Help
import androidx.compose.material.icons.automirrored.outlined.SendToMobile
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.MonetizationOn
import androidx.compose.material.icons.outlined.Money
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.rememberNavController
import com.czy.jetpack_compose.features.menu.domain.models.MenuOptionItem
import com.czy.jetpack_compose.ui.theme.Learning_lab2Theme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MenuOptions(onOptionClick: (option: MenuOptionItem) -> Unit = {}) {

    val optionList = listOf(
        MenuOptionItem(title = "Transferir", icon = Icons.AutoMirrored.Outlined.SendToMobile),
        MenuOptionItem(title = "Efectivo Móvil", icon = Icons.Outlined.MonetizationOn),
        MenuOptionItem(title = "Depositar", icon = Icons.Outlined.AttachMoney),
        MenuOptionItem(title = "Retirar", icon = Icons.Outlined.Money),
        MenuOptionItem(title = "Ajustes", icon = Icons.Outlined.Settings),
        MenuOptionItem(title = "Ayuda", icon = Icons.AutoMirrored.Outlined.Help),
    )

    FlowRow(
        modifier = Modifier
            .padding(horizontal = 8.dp),

        horizontalArrangement = Arrangement.spacedBy(4.dp),
        maxItemsInEachRow = 2
    ) {
        val itemModifier = Modifier
            .weight(1.0f)
            .padding(4.dp)

        optionList.forEach { option ->
            MenuOptionButton(option, itemModifier, onClick = {
                onOptionClick(option)
            })
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