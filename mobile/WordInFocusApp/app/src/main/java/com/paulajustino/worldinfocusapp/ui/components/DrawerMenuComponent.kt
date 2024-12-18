package com.paulajustino.worldinfocusapp.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Menu lateral (Drawer)
 *
 * @param onCloseClick Ação ao fechar o Drawer.
 */
@Composable
fun DrawerMenuComponent(
    onCloseClick: () -> Unit
) {
    // Itens do menu Drawer
    val menuItems = listOf("opção 1", "opção 2", "opçao 3")
    val selectedMenuItem = remember { mutableStateOf(menuItems[0]) }

    ModalDrawerSheet {
        Spacer(Modifier.height(12.dp))
        menuItems.forEach { item ->
            NavigationDrawerItem(
                label = { Text(item) },
                selected = item == selectedMenuItem.value,
                onClick = {
                    onCloseClick()
                    selectedMenuItem.value = item
                },
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )
        }
    }
}