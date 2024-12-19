package com.paulajustino.worldinfocusapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.paulajustino.worldinfocusapp.domain.model.menu.MenuItemModel
import com.paulajustino.worldinfocusapp.domain.model.newsFeed.NewsItemModel

/**
 * HorizontalPager para exibição das abas do feed de forma deslizante.
 *
 * @param pagerState Estado do pager
 */
@Composable
fun HorizontalPagerComponent(
    pagerState: PagerState,
    news: List<NewsItemModel>,
    selectedTabIndex: Int,
    onMenuItemSelected: (MenuItemModel) -> Unit,
    menuItems: List<MenuItemModel>
) {
    Column {
        if (selectedTabIndex == 2) {
            MenuTabComponent(
                menuItems = menuItems,
                onItemClick = { menuItem ->
                    onMenuItemSelected(menuItem)
                }
            )
        }

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

@Composable
fun MenuTabComponent(menuItems: List<MenuItemModel>, onItemClick: (MenuItemModel) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        menuItems.forEach { item ->
            Text(
                text = item.title,
                modifier = Modifier
                    .clickable { onItemClick(item) }
                    .padding(vertical = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}