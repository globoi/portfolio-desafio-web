package com.desafio.portifolionews.ui.menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MenuScreen(
    menuContent: MenuContent,
    onNavigateToMenuItem: (String) -> Unit = {}
) {
    Column {

        menuContent.menuItems.forEach { item ->
            MenuElements(
                modifier = Modifier.clickable {
                    onNavigateToMenuItem(item.url)
                }, title = item.title
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuScreenPreview() {
    MenuScreen(
        MenuContent(
            listOf(
                MenuItem("teste", "teste"),
                MenuItem("teste", "teste"),
                MenuItem("teste", "teste"),
                MenuItem("teste", "teste")
            )
        )
    )
}
