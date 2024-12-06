package com.desafio.portifolionews.ui.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavHostController
import com.desafio.feed.presentation.ui.navigation.NavigationItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Tabs(onTabSelectedChange: (NavigationItem) -> Unit = {}) {

    val titles = listOf("Home", "Economia", "Menu")
    var tabIndex by remember { mutableStateOf(0) }

    PrimaryTabRow(selectedTabIndex = tabIndex) {
        titles.forEachIndexed { index, title ->
            Tab(
                selected = tabIndex == index,
                onClick = {
                    tabIndex = index
                          },
                text = { Text(text = title, maxLines = 2, overflow = TextOverflow.Ellipsis) }
            )
        }
    }

    when (tabIndex) {
        0 -> onTabSelectedChange(NavigationItem.Feed)
        1 -> onTabSelectedChange(NavigationItem.Economy)
        2 -> onTabSelectedChange(NavigationItem.Menu)
    }
}
