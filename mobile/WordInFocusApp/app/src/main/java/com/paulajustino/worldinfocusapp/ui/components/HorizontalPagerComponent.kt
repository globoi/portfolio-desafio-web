package com.paulajustino.worldinfocusapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.paulajustino.worldinfocusapp.domain.model.NewsItem

/**
 * HorizontalPager para exibição das abas do feed de forma deslizante.
 *
 * @param pagerState Estado do pager
 */
@Composable
fun HorizontalPagerComponent(pagerState: PagerState, news: List<NewsItem>) {
    Column {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { pageIndex ->
            when (pageIndex) {
                0 -> NewsFeedComponent(newsItems = news)
                1 -> NewsFeedComponent(newsItems = news)
            }
        }
    }
}