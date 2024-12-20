package com.paulajustino.worldinfocusapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.paulajustino.worldinfocusapp.R

/**
 * Barra superior (TopBar) da tela.
 *
 *
 * @param title Título exibido na barra.
 * @param showBackButton Se verdadeiro, exibe o botão de voltar.
 * @param onBackClick Função callback que é chamada quando o botão de voltar é clicado.
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
                        tint = Color.DarkGray,
                        contentDescription = stringResource(R.string.back_button_content_description)
                    )
                }
            }
        },
        title = {
            Text(
                text = title,
                color = Color.DarkGray
            )
        }
    )
}