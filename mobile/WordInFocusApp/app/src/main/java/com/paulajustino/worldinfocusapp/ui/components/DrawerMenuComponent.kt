package com.paulajustino.worldinfocusapp.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.paulajustino.worldinfocusapp.domain.model.menu.MenuItemModel

/**
 * Menu lateral (Drawer)
 *
 * @param menuItems Lista de itens do menu
 * @param onItemClick Ação ao fechar o Drawer.
 */
@Composable
fun DrawerMenuComponent(
    menuItems: List<MenuItemModel>,
    onItemClick: (MenuItemModel) -> Unit
) {
    ModalDrawerSheet {
        Spacer(Modifier.height(12.dp))
        menuItems.forEach { item ->
            NavigationDrawerItem(
                label = { Text(item.title) },
                selected = false,
                onClick = {
                    onItemClick(item)
                },
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )
        }
    }
}