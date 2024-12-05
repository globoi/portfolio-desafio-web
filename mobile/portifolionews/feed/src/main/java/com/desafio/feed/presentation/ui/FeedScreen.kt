package com.desafio.feed.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.desafio.feed.presentation.ui.widgets.PostList

@Composable
fun FeedScreen(feedViewModel: FeedViewModel) {
    val state by feedViewModel.feedState.collectAsState()

    when (state) {
        FeedState.START -> {
            feedViewModel.loadFeed()
        }

        is FeedState.SUCCESS -> {
            val feed = (state as FeedState.SUCCESS)
            PostList(
                contentList = feedViewModel.loadNextPage(
                    "g1",
                    feed.feedDTO.oferta
                ),
                posts = feed.feedDTO.postList,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxHeight()
            )
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

        is FeedState.FETCH -> {
            val news = (state as FeedState.FETCH).feedNews
            PostList(
                contentList = feedViewModel.loadNextPage(
                   "g1",
                    "4af56893-1f9a-4504-9531-74458e481f91"
                ),
                posts = news,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxHeight()
            )
        }
    }
}
