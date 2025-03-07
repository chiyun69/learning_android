package com.czy.learning_lab2.features.account.ui.components.movement

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import com.czy.learning_lab2.features.account.ui.screens.AccountScreenPreview

@Composable
fun AccountMovements(
    modifier: Modifier = Modifier,
    ) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
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
                Text("Transferencias")
                Text(
                    "Referencia 1",
                    modifier = Modifier.padding(top = 4.dp),
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Light,
                    fontSize = MaterialTheme.typography.labelSmall.fontSize
                )
                Text(
                    "Referencia 2",
                    modifier = Modifier.padding(top = 4.dp),
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Light,
                    fontSize = MaterialTheme.typography.labelSmall.fontSize
                )
                Text(
                    "Referencia 3",
                    modifier = Modifier.padding(top = 4.dp),
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Light,
                    fontSize = MaterialTheme.typography.labelSmall.fontSize
                )
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    "$200.00",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "$312.34",
                    fontSize = MaterialTheme.typography.labelSmall.fontSize,
                    modifier = Modifier.padding(top = 4.dp),
                    fontWeight = FontWeight.Light,
                    color = Color.DarkGray
                )
            }
        }
    }
}

@Preview
@Composable
fun AccountMovementsPreview(){
    Surface {
        AccountMovements(modifier = Modifier.padding(12.dp))
    }
}

@Preview
@Composable
fun AccountMovementsPreview2(){
    Surface {
        AccountScreenPreview()
    }
}