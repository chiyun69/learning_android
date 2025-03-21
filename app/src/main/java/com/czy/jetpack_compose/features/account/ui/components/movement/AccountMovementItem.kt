package com.czy.jetpack_compose.features.account.ui.components.movement

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.czy.jetpack_compose.features.account.domain.models.Movement
import com.czy.jetpack_compose.ui.theme.Learning_lab2Theme

@Composable
fun AccountMovementItem(
    modifier: Modifier = Modifier,
    movement: Movement
    ) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Gray.copy(0.1f)
        ),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Column {
                Text(movement.description)
                MovementReference(movement.ref1)
                MovementReference(movement.ref2 )
                MovementReference(movement.ref3)

            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    "$ " + movement.amount,
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.titleMedium.fontSize
                )
                MovementReference("$ " + movement.balance)
            }
        }
    }
}

@Preview
@Composable
fun AccountMovementItemPreview(){
    Learning_lab2Theme {
        Surface {
            AccountMovementItem(
                modifier = Modifier.padding(12.dp),
                movement = Movement(
                    "1",
                    "1234567890",
                    1000.00,
                    200.00,
                    "Transferencias",
                    "Referencia 1",
                    "Referencia 2",
                    "Referencia 3")
            )
        }
    }
}

