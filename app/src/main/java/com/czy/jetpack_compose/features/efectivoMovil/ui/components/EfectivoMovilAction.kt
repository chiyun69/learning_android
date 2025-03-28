package com.czy.jetpack_compose.features.efectivoMovil.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.czy.jetpack_compose.ui.theme.Learning_lab2Theme

@Composable
fun EfectivoMovilAction(title: String, subtitle: String, onClick: () -> Unit = {}){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(12))
            .background(MaterialTheme.colorScheme.surfaceContainer)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        IconButton(
            modifier = Modifier.padding(8.dp),
            onClick = { /* Handle click */ }
        ) {
            Icon(Icons.Filled.ChevronRight, "Go")
        }
    }
}

@Preview
@Composable
fun EfectivoMovilActionPreview(){
    Learning_lab2Theme {
        Surface {
            EfectivoMovilAction(
                "Enviar",
                "Envía dinero a tus contactos"
            )
        }
    }
}