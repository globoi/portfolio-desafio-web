package com.paulajustino.worldinfocusapp.ui.components

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.paulajustino.worldinfocusapp.R
import com.paulajustino.worldinfocusapp.ui.model.NewsItemUiModel
import com.paulajustino.worldinfocusapp.ui.viewmodel.NewsFeedViewModel
import kotlinx.coroutines.launch

/**
 * Lista de notícias.
 *
 * A lista pode ser atualizada via gesto de "Pull-to-refresh".
 *
 * @param newsType Tipo de notícias (ex: "Recentes", "Agronegócio").
 * @param onNewsItemClick Callback acionado quando um item de notícia é clicado.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsFeedComponent(
    newsType: String,
    onNewsItemClick: (NewsItemUiModel) -> Unit
) {
    val newsFeedViewModel: NewsFeedViewModel = hiltViewModel()

    // Estado para gerenciar o comportamento de refresh
    var isRefreshing by remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()

    // Observa as notícias do ViewModel filtradas pelo tipo
    val newsItems by remember {
        derivedStateOf { newsFeedViewModel.newsByType[newsType] ?: emptyList() }
    }

    PullToRefreshBox(
        state = rememberPullToRefreshState(),
        isRefreshing = isRefreshing,
        onRefresh = {
            scope.launch {
                isRefreshing = true
                newsFeedViewModel.refreshNews(newsType)
                isRefreshing = false
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(top = 12.dp, bottom = 12.dp, start = 12.dp, end = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(newsItems) { newsItem ->
                NewsItemComponent(newsItem, onNewsItemClick)
            }
        }
    }
}

/**
 * Card contendo as informações de uma notícia.
 *
 * O card é interativo e pode ser clicado para abrir um WebView com detalhes da notícia.
 *
 * @param newsItem Item de notícia.
 * @param onNewsItemClick Função chamada ao clicar no item de notícia.
 */
@Composable
fun NewsItemComponent(
    newsItem: NewsItemUiModel,
    onNewsItemClick: (NewsItemUiModel) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(enabled = true, onClick = { onNewsItemClick(newsItem) })
        ) {
            newsItem.imageUrl?.let {
                NewsItemImageComponent(
                    imageUrl = it, contentDescription = stringResource(
                        R.string.image_news_content_description,
                        newsItem.title.orEmpty()
                    )
                )
            }
            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                newsItem.subSection?.let {
                    Text(
                        text = it,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray,
                        style = MaterialTheme.typography.titleSmall
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                newsItem.title?.let {
                    Text(
                        text = it,
                        fontWeight = FontWeight.Bold,
                        color = Color.DarkGray,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                newsItem.summary?.let {
                    Text(
                        text = it,
                        color = Color.DarkGray,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                newsItem.metaData?.let {
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 16.dp),
                        color = Color.DarkGray,
                        thickness = 1.dp
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = it,
                            style = MaterialTheme.typography.labelMedium,
                            color = Color.DarkGray
                        )
                    }
                }
            }
        }
    }
}

/*@Composable
fun NewsFeedPagedComponent(
    newsItems: LazyPagingItems<NewsItemModel>
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(top = 12.dp, bottom = 12.dp, start = 12.dp, end = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(newsItems.itemCount) { index ->
            val newsItem = newsItems[index]
            // Checa se o item não é nulo
            newsItem?.let {
                NewsItemComponent(it) // Passa somente itens não nulos
            }
        }

        // Exibe um indicador de carregamento no final da lista durante a paginação
        newsItems.apply {
            when {
                loadState.append is LoadState.Loading -> {
                    item {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .wrapContentWidth(Alignment.CenterHorizontally)
                        )
                    }
                }

                loadState.append is LoadState.Error -> {
                    item {
                        Text(
                            text = "Erro ao carregar mais itens.",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .wrapContentWidth(Alignment.CenterHorizontally),
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                }
            }
        }
    }
}*/