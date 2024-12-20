package com.paulajustino.worldinfocusapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.paulajustino.worldinfocusapp.domain.model.menu.MenuItemModel
import com.paulajustino.worldinfocusapp.domain.model.newsFeed.NewsFeedState
import com.paulajustino.worldinfocusapp.ui.components.BottomBarComponent
import com.paulajustino.worldinfocusapp.ui.components.DrawerMenuComponent
import com.paulajustino.worldinfocusapp.ui.components.HorizontalPagerComponent
import com.paulajustino.worldinfocusapp.ui.components.TabsComponent
import com.paulajustino.worldinfocusapp.ui.components.TopBarComponent
import com.paulajustino.worldinfocusapp.ui.model.NewsItemUiModel
import com.paulajustino.worldinfocusapp.ui.theme.WorldInFocusAppTheme
import com.paulajustino.worldinfocusapp.ui.viewmodel.MenuViewModel
import com.paulajustino.worldinfocusapp.ui.viewmodel.NewsFeedViewModel
import com.paulajustino.worldinfocusapp.utils.NewsType
import kotlinx.coroutines.launch

/**
 * Tela inicial da aplicação, com TopBar, BottomBar, HorizontalPager e um Drawer lateral.
 */
@Composable
fun HomeScreen() {
    val newsFeedViewModel: NewsFeedViewModel = hiltViewModel()
    val menuViewModel: MenuViewModel = hiltViewModel()

    // Estado da tab selecionada
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabs = remember { mutableStateListOf("Feed", "Agronegócio", "Mais") }

    // Estados do pager e do drawer
    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    val scope = rememberCoroutineScope()

    // Observa o estado do feed
    val newsState = newsFeedViewModel.newsFeedState.collectAsState().value

    // Observa o estado do menu
    val menuItems by menuViewModel.menuItems.collectAsState()

    // Estado unificado para rastrear seleção tanto de item de menu quanto de item de notícia
    var selectedWebViewUrl by remember { mutableStateOf<String?>(null) }

    selectedWebViewUrl?.let { url ->
        // Exibe a WebView genérica
        GenericWebViewScreen(
            url = url,
            onBackPressed = { selectedWebViewUrl = null } // Fecha a WebView ao voltar
        )
    } ?: run {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                DrawerMenuComponent(menuItems, onMenuItemClick = { selected ->
                    selectedWebViewUrl = selected.url
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

                            // Exibe o conteúdo dependendo do estado do feed
                            when (newsState) {
                                is NewsFeedState.Loading -> ShowLoadingIndicator()
                                is NewsFeedState.Success -> ShowNews(
                                    pagerState = pagerState,
                                    newsType = if (selectedTabIndex == 0) NewsType.RECENTS.type else NewsType.AGRO.type,
                                    menuItems = menuItems,
                                    onMenuItemClick = { menuItem ->
                                        selectedWebViewUrl = menuItem.url
                                    },
                                    onNewsItemClick = { newsItem ->
                                        selectedWebViewUrl = newsItem.url
                                    }
                                )

                                is NewsFeedState.Error -> ShowError(message = newsState.message)
                            }
                        }
                    }
                )
            }
        )
    }

    // Sincroniza o índice da tab com a página atual do pager
    LaunchedEffect(pagerState.currentPage) {
        selectedTabIndex = pagerState.currentPage
    }
}

@Composable
private fun ShowLoadingIndicator() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
private fun ShowNews(
    pagerState: PagerState,
    newsType: String,
    menuItems: List<MenuItemModel>,
    onMenuItemClick: (MenuItemModel) -> Unit,
    onNewsItemClick: (NewsItemUiModel) -> Unit
) {
    HorizontalPagerComponent(
        pagerState,
        newsType,
        menuItems,
        onMenuItemClick,
        onNewsItemClick
    )
}

@Composable
private fun ShowError(message: String) {
    Text("Erro ao carregar feed: $message")
}

@Preview
@Composable
fun HomeScreenPreview() {
    WorldInFocusAppTheme {
        HomeScreen()
    }
}

/*@Composable
fun HomeScreenWithPaging() {
    val newsFeedViewModel: NewsFeedViewModel = hiltViewModel()
    val menuViewModel: MenuViewModel = hiltViewModel()

    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabs = remember { mutableStateListOf("Recentes", "Agronegócio", "Mais") }

    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    val scope = rememberCoroutineScope()


    val menuItems by menuViewModel.menuItems.collectAsState()

    var selectedMenuItem: MenuItemModel? by remember { mutableStateOf(null) }

    selectedMenuItem?.let { menuItem ->
        MenuItemWebViewScreen(
            url = menuItem.url,
            onBackPressed = { selectedMenuItem = null } // Redefine o estado ao voltar
        )
    } ?: run {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                DrawerMenuComponent(menuItems, onItemClick = { selected ->
                    selectedMenuItem = selected
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

                            when (selectedTabIndex) {
                                0, 1 -> ShowNewsFeed(pagerState, newsFeedViewModel.newsFlows)
                                2 -> ShowMenu(
                                    onMenuItemSelected = { menuItem ->
                                        selectedMenuItem = menuItem
                                    },
                                    menuItems = menuItems
                                )
                            }
                        }
                    }
                )
            }
        )
    }
}

@Composable
fun ShowNewsFeed(
    pagerState: PagerState,
    newsFlow: Map<String, StateFlow<PagingData<NewsItemModel>>>
) {
    HorizontalPagerComponent(
        pagerState = pagerState,
        newsFlow = newsFlow
    )

}*/
