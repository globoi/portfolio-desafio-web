package com.desafio.portifolionews.ui.menu

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
fun MenuElements(
    modifier: Modifier,
    title: String
) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(modifier = modifier, text = title)
        HorizontalDivider(thickness = 2.dp)
    }
}

@Preview(showBackground = true)
@Composable
fun MenuElementsPreview() {
    MenuElements(
        modifier = Modifier, "Teste"
    )
}
