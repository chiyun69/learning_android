package com.czy.jetpack_compose.features.account.ui.components.movement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.czy.jetpack_compose.features.account.domain.models.Movement
import com.czy.jetpack_compose.ui.theme.Learning_lab2Theme

@Composable
fun AccountMovementList(
    modifier: Modifier = Modifier,
    movementList: List<Movement> = emptyList()
    ) {
    Column(modifier = modifier) {
        movementList.forEach { movement ->
            AccountMovementItem(
                movement = movement,
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }
    }
}

@Preview
@Composable
fun AccountMovementsPreview(){
    val movementList = listOf(
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
        ),
    )

    Learning_lab2Theme {
        Surface {
            AccountMovementList(movementList = movementList, modifier = Modifier.padding(12.dp))
        }
    }


}