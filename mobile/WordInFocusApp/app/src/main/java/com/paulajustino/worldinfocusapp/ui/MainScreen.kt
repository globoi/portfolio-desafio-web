package com.paulajustino.worldinfocusapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.paulajustino.worldinfocusapp.ui.components.BottomBarComponent
import com.paulajustino.worldinfocusapp.ui.components.DrawerMenuComponent
import com.paulajustino.worldinfocusapp.ui.components.FeedComponent
import com.paulajustino.worldinfocusapp.ui.components.TopBarComponent
import kotlinx.coroutines.launch

/**
 * Tela principal da aplicação, com TopBar, BottomBar, HorizontalPager e um Drawer lateral.
 */
@Composable
fun MainScreen() {
    // Estado da tab selecionada
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabs = remember { mutableStateListOf("Feed", "Agronegócio") }

    // Estados do pager e do drawer
    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    val scope = rememberCoroutineScope()

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

                        HorizontalPagerComponent(pagerState)
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

/**
 * Tabs de navegação do feed.
 *
 * @param tabs Lista de títulos das abas que serão exibidas.
 * @param selectedTabIndex Índice da aba atualmente selecionada.
 * @param onTabSelected Função callback que é chamada quando uma aba é selecionada,
 *                     passando o índice da aba selecionada.
 */
@Composable
fun TabsComponent(tabs: List<String>, selectedTabIndex: Int, onTabSelected: (Int) -> Unit) {
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = Modifier.fillMaxWidth()
    ) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { onTabSelected(index) },
                text = { Text(tab) }
            )
        }
    }
}

/**
 * HorizontalPager para exibição das abas do feed de forma deslizante.
 *
 * @param pagerState Estado do pager
 */
@Composable
fun HorizontalPagerComponent(pagerState: PagerState) {
    Column {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { pageIndex ->
            when (pageIndex) {
                0 -> FeedComponent()
                1 -> FeedComponent()
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}