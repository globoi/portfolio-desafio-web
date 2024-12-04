package com.desafio.feed.presentation.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.desafio.feed.R
import com.desafio.feed.domain.model.ImageInfo
import com.desafio.feed.domain.model.New
import com.desafio.feed.domain.model.NewContent
import com.desafio.feed.presentation.ui.theme.TypographyTitle


@Composable
fun Title(title: String) {
    Text(
        text = title,
        style = Typography,
        color = colorResource(id = androidx.loader.R.color.ripple_material_light),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 8.dp),
        textAlign = TextAlign.Center,
        fontSize = 14.sp
    )
}


@Preview(showBackground = true)
@Composable
fun FeedPreview() {
    Title("Testando o Código")
}
