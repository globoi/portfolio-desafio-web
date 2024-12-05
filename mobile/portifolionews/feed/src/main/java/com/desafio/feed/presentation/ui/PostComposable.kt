package com.desafio.feed.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
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
import com.desafio.feed.domain.dto.NewsDto


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
            val feedNews = (state as FeedState.SUCCESS).feedNews
            NewsListScreen(feedNews)
        }
    }
}

@Composable
fun NewsListScreen(news: List<NewsDto>) {
    LazyColumn(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxHeight()
    ) {
        items(news) { item ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(150.dp)
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 6.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = item.chapeu, fontSize = 16.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 2.dp)
                    )

                    Text(
                        text = item.title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    item.image?.let {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(item.image)
                                .crossfade(true)
                                .build(),
                            modifier = Modifier
                                .fillMaxWidth().height(200.dp),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            placeholder = painterResource(id = R.drawable.placeholder)
                        )
                    }

                    Text(
                        text = item.summary, fontSize = 16.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 2.dp)
                    )

                    Text(
                        text = item.metadata, fontSize = 16.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 2.dp)
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsListScreen(
        listOf(
            NewsDto(
                title = "Title",
                summary = "Summary",
                chapeu = "Chapeu",
                image = "sdsdsdsdsdsd",
                metadata = "MetaData  - 20/01/1003",
                aggregatedPostDtos = null,
                url = ""
            ),NewsDto(
                title = "Title",
                summary = "Summary",
                chapeu = "Chapeu",
                image = "sdsdsdsdsdsd",
                metadata = "MetaData  - 20/01/1003",
                aggregatedPostDtos = null,
                url = ""
            ),NewsDto(
                title = "Title",
                summary = "Summary",
                chapeu = "Chapeu",
                image = "sdsdsdsdsdsd",
                metadata = "MetaData  - 20/01/1003",
                aggregatedPostDtos = null,
                url = ""
            ),NewsDto(
                title = "Title",
                summary = "Summary",
                chapeu = "Chapeu",
                image = "sdsdsdsdsdsd",
                metadata = "MetaData  - 20/01/1003",
                aggregatedPostDtos = null,
                url = ""
            )
        )
    )
}


