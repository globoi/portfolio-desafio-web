package com.paulajustino.worldinfocusapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.paulajustino.worldinfocusapp.R

/**
 * Barra de navegação inferior (NavigationBar) da tela.
 *
 * A barra contém dois itens de navegação: Início e Menu.
 *
 * @param selectedTabIndex Índice da aba selecionada para marcá-la na barra.
 * @param homeTabLabel Texto exibido no item "Início".
 * @param menuTabLabel Texto exibido no item "Menu".
 * @param onHomeClick Ação executada ao clicar no item "Início".
 * @param onMenuClick Ação executada ao clicar no item "Menu".
 */
@Composable
fun BottomBarComponent(
    selectedTabIndex: Int,
    homeTabLabel: String,
    menuTabLabel: String,
    onHomeClick: () -> Unit,
    onMenuClick: () -> Unit
) {
    NavigationBar {
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = stringResource(R.string.home_tab_content_description)
                )
            },
            label = { Text(homeTabLabel) },
            selected = selectedTabIndex == 0,
            onClick = onHomeClick,
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.Menu,
                    contentDescription = stringResource(R.string.menu_tab_content_description)
                )
            },
            label = { Text(menuTabLabel) },
            selected = false,
            onClick = onMenuClick
        )
    }
}