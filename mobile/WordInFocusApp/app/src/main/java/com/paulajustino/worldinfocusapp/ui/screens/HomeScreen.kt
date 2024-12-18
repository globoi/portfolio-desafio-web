package com.paulajustino.worldinfocusapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulajustino.worldinfocusapp.domain.model.NewsState
import com.paulajustino.worldinfocusapp.domain.model.NewsItemModel
import com.paulajustino.worldinfocusapp.ui.components.BottomBarComponent
import com.paulajustino.worldinfocusapp.ui.components.DrawerMenuComponent
import com.paulajustino.worldinfocusapp.ui.components.HorizontalPagerComponent
import com.paulajustino.worldinfocusapp.ui.components.TabsComponent
import com.paulajustino.worldinfocusapp.ui.components.TopBarComponent
import com.paulajustino.worldinfocusapp.ui.theme.WorldInFocusAppTheme
import com.paulajustino.worldinfocusapp.ui.viewmodel.NewsFeedViewModel
import kotlinx.coroutines.launch

/**
 * Tela inicial da aplicação, com TopBar, BottomBar, HorizontalPager e um Drawer lateral.
 */
@Composable
fun HomeScreen(viewModel: NewsFeedViewModel) {
    // Estado da tab selecionada
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabs = remember { mutableStateListOf("Feed", "Agronegócio") }

    // Estados do pager e do drawer
    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    val scope = rememberCoroutineScope()

    // Observa o estado do feed
    val feedState = viewModel.newsState.collectAsState().value

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerMenuComponent(onCloseClick = {
                scope.launch { drawerState.close() }
            })
        },
        content = {
            Scaffold(
                topBar = {
                    TopBarComponent(
                        title = "Mundo em Foco",
                        showBackButton = pagerState.currentPage > 0,
                        onBackClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage - 1)
                            }
                        })
                },
                bottomBar = {
                    BottomBarComponent(
                        selectedTabIndex = selectedTabIndex,
                        homeTabLabel = "Início",
                        menuTabLabel = "Menu",
                        onHomeClick = {
                            selectedTabIndex = 0
                            scope.launch { pagerState.animateScrollToPage(0) }
                        },
                        onMenuClick = {
                            scope.launch { drawerState.open() }
                        })
                },
                content = { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        TabsComponent(
                            tabs = tabs,
                            selectedTabIndex = selectedTabIndex,
                            onTabSelected = { index ->
                                selectedTabIndex = index
                                scope.launch {
                                    pagerState.animateScrollToPage(index)
                                }
                            }
                        )

                        // Exibe o conteúdo dependendo do estado
                        when (feedState) {
                            is NewsState.Loading -> ShowLoadingIndicator()
                            is NewsState.Success -> ShowNews(pagerState, feedState.news)
                            is NewsState.Error -> ShowError(feedState.message)
                        }
                    }
                }
            )
        }
    )

    // Sincroniza o índice da tab com a página atual do pager
    LaunchedEffect(pagerState.currentPage) {
        selectedTabIndex = pagerState.currentPage
    }
}

@Composable
private fun ShowLoadingIndicator() {
    CircularProgressIndicator(modifier = Modifier.padding(16.dp))
}

@Composable
private fun ShowNews(pagerState: PagerState, news: List<NewsItemModel>) {
    HorizontalPagerComponent(pagerState, news)
}

@Composable
private fun ShowError(message: String) {
    Text("Erro ao carregar feed: $message")
}

/*
@Preview
@Composable
fun HomeScreenPreview() {
    WorldInFocusAppTheme {
        HomeScreen(viewModel = NewsFeedViewModel())
    }
}*/
