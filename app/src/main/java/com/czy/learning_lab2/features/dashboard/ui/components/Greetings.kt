package com.czy.learning_lab2.features.dashboard.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Greetings(name: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Text(
            text = "Hola, "
        )
        Text(
            text = "$name!",
            modifier = modifier,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Surface {
        Greetings("CZY")
    }
}