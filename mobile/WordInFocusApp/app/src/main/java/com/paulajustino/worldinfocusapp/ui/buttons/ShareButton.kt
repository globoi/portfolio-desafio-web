package com.paulajustino.worldinfocusapp.ui.buttons

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Botão de compartilhamento.
 *
 * @param onClick Ação ao clicar no botão.
 */
@Composable
fun ShareButton(onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(48.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Share,
            contentDescription = "Compartilhar",
            tint = Color.Black
        )
    }
}