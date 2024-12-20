package com.paulajustino.worldinfocusapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.paulajustino.worldinfocusapp.domain.model.menu.MenuItemModel

/**
 * Menu da aba "Menu".
 *
 * Cada item de menu é interativo e chama uma função de callback ao ser clicado.
 *
 * @param menuItems Lista de itens de menu.
 * @param onMenuItemClick Função chamada quando um item de menu é clicado.
 */
@Composable
fun MenuTabComponent(menuItems: List<MenuItemModel>, onMenuItemClick: (MenuItemModel) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        menuItems.forEach { item ->
            Text(
                text = item.title,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .clickable { onMenuItemClick(item) }
                    .padding(vertical = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}