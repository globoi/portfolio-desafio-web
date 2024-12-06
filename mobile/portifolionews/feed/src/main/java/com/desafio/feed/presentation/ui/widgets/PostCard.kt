package com.desafio.feed.presentation.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.desafio.feed.R
import com.desafio.feed.presentation.ui.dto.NewsDto

@Composable
fun PostCard(
    postCardModifier: Modifier,
    post: NewsDto,
    onNavigateToNew: (String) -> Unit = {}
) {

    Column(
        modifier = postCardModifier
            .fillMaxWidth()
            .heightIn(150.dp)
            .padding(vertical = 16.dp, horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onNavigateToNew(post.url)
                },
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = post.chapeu, fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 2.dp)
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                text = post.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            post.image?.let {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(post.image)
                        .crossfade(true)
                        .build(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.placeholder)
                )
            }


            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = post.summary, fontSize = 16.sp,
                modifier = Modifier.padding(top = 2.dp)
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = post.metadata, fontSize = 16.sp,
                modifier = Modifier.padding(top = 2.dp)
            )
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        post.aggregatedPostDtos?.forEach { item ->
            Column(
                modifier = postCardModifier
                    .padding(vertical = 16.dp)
                    .clickable {
                        onNavigateToNew(item.url)
                    },
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                HorizontalDivider(thickness = 2.dp)
                Text(modifier = postCardModifier, text = item.title)
            }
        }
    }

    Spacer(
        modifier = Modifier.height(16.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun PostCardPreview() {
    PostCard(
        postCardModifier = Modifier
            .fillMaxWidth()
            .heightIn(150.dp)
            .padding(horizontal = 8.dp),
        NewsDto(
            title = "Title",
            summary = "Summary",
            chapeu = "Chapeu",
            image = "sdsdsdsdsdsd",
            metadata = "MetaData  - 20/01/1003",
            aggregatedPostDtos = null,
            url = ""
        )
    )
}