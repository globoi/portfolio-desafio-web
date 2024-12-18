package com.paulajustino.worldinfocusapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.paulajustino.worldinfocusapp.R
import com.paulajustino.worldinfocusapp.domain.model.NewsItem
import com.paulajustino.worldinfocusapp.ui.buttons.ShareButton

/**
 * Lista genérica de notícias.
 *
 * @param newsItems Lista de notícias a ser exibida no feed.
 * @param onNewsClick Callback ao clicar em um item de notícia.
 */
@Composable
fun GenericFeedComponent(
    newsItems: List<NewsItem> = emptyList(),
    onNewsClick: (String) -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(top = 12.dp, bottom = 12.dp, start = 12.dp, end = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(newsItems) { newsItem ->
            NewsComponent(newsItem)
        }
    }
}

/**
 * Card que exibe informações de uma notícia.
 */
@Composable
fun NewsComponent(
    newsItem: NewsItem
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Gray),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .clickable { }
        ) {
            Image(
                painter = painterResource(id = R.mipmap.ic_world_in_focus_foreground),
                contentDescription = "Imagem dentro do card",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(topStart = 6.dp))
            )
            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                newsItem.chapeu?.let { Text(text = it, style = MaterialTheme.typography.titleSmall) }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = newsItem.title,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = newsItem.description,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 16.dp),
                    color = Color.Black,
                    thickness = 1.dp
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = newsItem.metadata,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Black
                    )
                    ShareButton { }
                }
            }
        }
    }
}