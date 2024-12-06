package com.desafio.portifolionews.ui.menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MenuScreen(
    menuContent: MenuContent,
    onNavigateToMenuItem: (String) -> Unit = {}
) {
    Column {

        menuContent.menuItems.forEach { item ->
            Text(modifier = Modifier.clickable {
                onNavigateToMenuItem(item.url)
            }, text = item.title)
        }
    }
}
