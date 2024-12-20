package com.paulajustino.worldinfocusapp.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.paulajustino.worldinfocusapp.domain.model.menu.MenuItemModel

/**
 * Menu lateral (Drawer).
 *
 * Exibe uma lista de itens de menu num painel lateral (Drawer).
 * Cada item pode ser selecionado, e ao clicar, é aberta uma webView com detalhes do item.
 *
 * @param menuItems Lista de itens do menu a serem exibidos no Drawer.
 * @param onMenuItemClick Função que é chamada quando um item do menu é clicado.
 */
@Composable
fun DrawerMenuComponent(
    menuItems: List<MenuItemModel>,
    onMenuItemClick: (MenuItemModel) -> Unit
) {
    ModalDrawerSheet {
        Spacer(Modifier.height(12.dp))
        menuItems.forEach { item ->
            NavigationDrawerItem(
                label = {
                    Text(
                        text = item.title,
                        fontWeight = FontWeight.Bold,
                        color = Color.DarkGray,
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                selected = false,
                onClick = {
                    onMenuItemClick(item)
                },
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )
        }
    }
}