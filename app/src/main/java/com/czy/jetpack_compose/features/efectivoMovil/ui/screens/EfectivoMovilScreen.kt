package com.czy.jetpack_compose.features.efectivoMovil.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.rememberNavController
import com.czy.jetpack_compose.features.efectivoMovil.ui.components.EfectivoMovilAction
import com.czy.jetpack_compose.ui.theme.Learning_lab2Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EfectivoMovilScreen(navController: NavController, toggleMenuSheet: (show: Boolean) -> Unit){
    val sheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = {
            toggleMenuSheet(false)
        },
        sheetState = sheetState,
        modifier = Modifier.fillMaxHeight(),
    ) {
        SheetContent()
    }
}

@Composable
fun SheetContent() {
    Column (
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = "Efectivo Móvil",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(12.dp)
        )

        EfectivoMovilAction(
            "Enviar",
            "Envía dinero a tus contactos"

        )

        EfectivoMovilAction(
            "Pendientes por retirar",
            "Consulta y cancela tus envíos activos"

        )
    }
}

@Preview
@Composable
fun EfectivoMovilScreenPreview(){
    Learning_lab2Theme {
        val navController = rememberNavController()
        navController.navigatorProvider.addNavigator(ComposeNavigator())
        Surface {
            SheetContent()
        }
    }
}