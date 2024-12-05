package com.desafio.feed.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.desafio.feed.domain.model.New
import com.desafio.feed.domain.model.NewContent


@Composable
fun MainView(feedViewModel: FeedViewModel) {
    val state by feedViewModel.feedState.collectAsState()

    when (state) {
        FeedState.START -> {
        }

        FeedState.LOADING -> {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator()
            }
        }

        is FeedState.FAILURE -> {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Text(text = "Something went wrong...", fontSize = 16.sp)
            }
        }

        is FeedState.SUCCESS -> {
            val feed = (state as FeedState.SUCCESS).feed
            NewsListScreen(feed.feed.falkor.items)
        }
    }
}

@Composable
fun NewsListScreen(news: List<New>) {
    LazyColumn(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxHeight()
    ) {
        items(news) { item ->

            Column(
                modifier = Modifier
                    .padding(start = 6.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = item.content?.chapeu?.label ?: "", fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 2.dp)
                )

                Text(
                    text = item.content?.title ?: "",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://s2-g1.glbimg.com/823PaUZLsSDF4TlXFw7PwYTtaBk=/0x0:1136x639/810x456/smart/https://i.s3.glbimg.com/v1/AUTH_59edd422c0c84a879bd37670ae4f538a/internal_photos/bs/2024/n/7/pPgPAaRdOFxgbZALWT5w/pai-jovem-jogado-ponte.jpg")
                        .crossfade(true)
                        .build(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(304.dp),
                    contentDescription = null,
                    placeholder = painterResource(id = R.drawable.placeholder)
                )

                Text(
                    text = item.content?.summary ?: "", fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 2.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsListScreen(
        listOf(
            New(
                "sas", "sas", NewContent(
                    chapeu = "asasa",
                    summary = "sdfsdfs f sdfs f",
                    title = "Titulo e tals",
                    url = "Titulo e tals"
                )
            ), New(
                "sas", "sas", NewContent(
                    chapeu = "asasa",
                    summary = "sdfsdfs f sdfs f",
                    title = "Titulo e tals",
                    url = "Titulo e tals"
                )
            ), New(
                "sas", "sas", NewContent(
                    chapeu = "asasa",
                    summary = "sdfsdfs f sdfs f",
                    title = "Titulo e tals",
                    url = "Titulo e tals"
                )
            ), New(
                "sas", "sas", NewContent(
                    chapeu = "asasa",
                    summary = "sdfsdfs f sdfs f",
                    title = "Titulo e tals",
                    url = "Titulo e tals"
                )
            ), New(
                "sas", "sas", NewContent(
                    chapeu = "asasa",
                    summary = "sdfsdfs f sdfs f",
                    title = "Titulo e tals",
                    url = "Titulo e tals"
                )
            ), New(
                "sas", "sas", NewContent(
                    chapeu = "asasa",
                    summary = "sdfsdfs f sdfs f",
                    title = "Titulo e tals",
                    url = "Titulo e tals"
                )
            )
        )
    )
}

