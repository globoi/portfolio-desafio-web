package com.paulajustino.worldinfocusapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

/**
 * Imagem de uma notícia.
 *
 * Utiliza o Coil para carregamento assíncrono da imagem a partir de uma URL.
 *
 * @param imageUrl URL da imagem a ser exibida.
 * @param contentDescription Descrição da imagem para acessibilidade.
 */
@Composable
fun NewsItemImageComponent(
    imageUrl: String,
    contentDescription: String
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = contentDescription,
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clip(RoundedCornerShape(topStart = 6.dp)),
        contentScale = ContentScale.Crop,
    )
}