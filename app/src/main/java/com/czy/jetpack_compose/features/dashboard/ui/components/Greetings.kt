package com.czy.jetpack_compose.features.dashboard.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.czy.jetpack_compose.ui.theme.Learning_lab2Theme

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
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Learning_lab2Theme {
        Surface {
            Greetings("CZY")
        }
    }

}