package com.paulajustino.worldinfocusapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Tabs de navegação do feed.
 *
 * @param tabs Lista de títulos das abas que serão exibidas.
 * @param selectedTabIndex Índice da aba atualmente selecionada.
 * @param onTabSelected Função callback que é chamada quando uma aba é selecionada,
 *                     passando o índice da aba selecionada.
 */
@Composable
fun TabsComponent(
    tabs: List<String>,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
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