package com.desafio.feed.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.desafio.feed.presentation.ui.widgets.PostList
import com.desafio.feed.presentation.ui.widgets.PullToRefreshBox

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedScreen(
    content: String,
    feedViewModel: FeedViewModel,
    onNavigateToNew: (String) -> Unit = {}
) {

    val state by feedViewModel.feedState.collectAsState()

    when (state) {
        FeedState.START -> {
            feedViewModel.loadFeed(content)
        }

        is FeedState.SUCCESS -> {
            val feedState = (state as FeedState.SUCCESS)

            PullToRefreshBox(
                isRefreshing = feedState.isRefreshing,
                onRefresh = feedViewModel::onPullToRefreshTrigger,
                modifier = Modifier
                    .padding(8.dp)
            ) {
                PostList(
                    contentList = feedViewModel.loadNextPage(),
                    posts = feedState.feedDTO.postList,
                    modifier = Modifier,
                    onNavigateToNew = onNavigateToNew
                )
            }
        }

        is FeedState.REFRESH -> {
            feedViewModel.loadFeed(content)
        }

        is FeedState.LOADING -> {
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
            val feedState = (state as FeedState.FETCH)
                PostList(
                    contentList = feedViewModel.loadNextPage(),
                    posts = feedState.feedNews,
                    modifier = Modifier,
                    onNavigateToNew = onNavigateToNew
                )
            }
        }
}
