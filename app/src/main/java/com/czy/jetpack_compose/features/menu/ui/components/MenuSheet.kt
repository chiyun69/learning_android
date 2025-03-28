package com.czy.jetpack_compose.features.menu.ui.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuSheet(navController: NavController, toggleMenuSheet: (show: Boolean) -> Unit) {
    val sheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = {
            toggleMenuSheet(false)
        },
        sheetState = sheetState,
        modifier = Modifier.fillMaxHeight(),
    ) {
        // Sheet content
        Text(text = "Qué quieres hacer?",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(12.dp).padding(bottom = 8.dp)
        )
        MenuOptions()
    }
}
