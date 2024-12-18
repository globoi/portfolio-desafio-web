package com.paulajustino.worldinfocusapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

/**
 * Barra de navegação inferior (NavigationBar)
 *
 * @param selectedTabIndex Aba selecionada atualmente.
 * @param homeTabLabel Texto do item "Início".
 * @param menuTabLabel Texto do item "Menu".
 * @param onHomeClick Ação ao clicar em "Início".
 * @param onMenuClick Ação ao clicar em "Menu".
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
            icon = { Icon(Icons.Filled.Home, contentDescription = "Início") },
            label = { Text(homeTabLabel) },
            selected = selectedTabIndex == 0,
            onClick = onHomeClick
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Menu, contentDescription = "Menu") },
            label = { Text(menuTabLabel) },
            selected = false,
            onClick = onMenuClick
        )
    }
}