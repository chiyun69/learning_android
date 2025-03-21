package com.czy.jetpack_compose.features.account.ui.components.movement

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.czy.jetpack_compose.ui.theme.Learning_lab2Theme

@Composable
fun MovementReference(text: String) {
    if (text.isNotEmpty()) {
        Text(
            text,
            color = Color.Gray,
            fontSize = MaterialTheme.typography.labelSmall.fontSize,
            lineHeight = MaterialTheme.typography.labelSmall.lineHeight
        )
    }
}

@Preview
@Composable
fun MovementReferencePreview() {
    Learning_lab2Theme {
        Surface {
            Column {
                MovementReference("Referencia 123")
                MovementReference("Referencia 456")
            }
        }
    }
}

@Preview
@Composable
fun MovementReferencePreview2() {
    AccountMovementsPreview()
}