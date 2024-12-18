package com.paulajustino.worldinfocusapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

/**
 * Barra superior (TopBar)
 *
 * @param title Título exibido.
 * @param showBackButton Exibe ou não o botão de voltar.
 * @param onBackClick Ação ao clicar no botão de voltar.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComponent(
    title: String,
    showBackButton: Boolean,
    onBackClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar"
                    )
                }
            }
        },
        title = { Text(text = title) }
    )
}