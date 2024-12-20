package com.paulajustino.worldinfocusapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.paulajustino.worldinfocusapp.domain.model.menu.MenuItemModel
import com.paulajustino.worldinfocusapp.ui.model.NewsItemUiModel

/**
 * HorizontalPager para exibição das abas do feed de forma deslizante.
 *
 *
 * @param pagerState Estado atual do Pager para controlar o estado e navegação entre as páginas.
 * @param newsType Tipo de notícias a ser exibido.
 * @param menuItems Lista de itens de menu.
 * @param onMenuItemClick Função chamada quando um item de menu é clicado.
 * @param onNewsItemClick Função chamada quando uma notícia é clicada.
 */
@Composable
fun HorizontalPagerComponent(
    pagerState: PagerState,
    newsType: String,
    menuItems: List<MenuItemModel>,
    onMenuItemClick: (MenuItemModel) -> Unit,
    onNewsItemClick: (NewsItemUiModel) -> Unit
) {
    Column {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { pageIndex ->
            when (pageIndex) {
                // Exibe o Feed de Notícias
                0, 1 -> NewsFeedComponent(
                    newsType = newsType,
                    onNewsItemClick = onNewsItemClick
                )
                // Exibe o Menu
                2 -> MenuTabComponent(menuItems = menuItems, onMenuItemClick = onMenuItemClick)
            }
        }
    }
}

/*
@Composable
fun PagedHorizontalPagerComponent(
    pagerState: PagerState,
    newsFlow: Map<String, StateFlow<PagingData<NewsItemModel>>>
) {
    Column {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { pageIndex ->
            when (pageIndex) {
                0 -> {
                    val newsItems = newsFlow[NewsType.RECENTS.type]?.collectAsLazyPagingItems()
                    newsItems?.let {
                        NewsFeedPagedComponent(it)
                    }
                }
                1 -> {
                    val newsItems = newsFlow[NewsType.AGRO.type]?.collectAsLazyPagingItems()
                    newsItems?.let {
                        NewsFeedPagedComponent(it)
                    }
                }

            }
        }
    }
}*/
