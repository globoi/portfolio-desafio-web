package com.desafio.portifolionews.ui.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.desafio.feed.presentation.ui.navigation.NavigationItem
import com.desafio.portifolionews.ui.navigation.TopLevelRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContainer(
    onTabSelectedChange: (NavigationItem) -> Unit = {},
    content: @Composable () -> Unit
) {
    val topLevelRoutes = listOf(
        TopLevelRoute("Home", NavigationItem.Feed),
        TopLevelRoute("Economy", NavigationItem.Economy),
        TopLevelRoute("Menu", NavigationItem.Menu),
    )

    Column {



        Tabs(onTabSelectedChange)

        Box(
            modifier = Modifier.padding(8.dp)
        ) {
            content()
        }
    }

}