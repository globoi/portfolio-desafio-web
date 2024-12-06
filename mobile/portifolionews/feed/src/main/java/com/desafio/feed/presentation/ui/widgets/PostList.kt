package com.desafio.feed.presentation.ui.widgets

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.desafio.feed.presentation.ui.dto.NewsDto
import kotlinx.coroutines.flow.Flow

@Composable
fun PostList(
    contentList: Flow<PagingData<NewsDto>>? = null,
    posts: List<NewsDto>?,
    modifier: Modifier = Modifier
) {

    val lazyPagingItems = contentList?.collectAsLazyPagingItems()

    LazyColumn(
        modifier = modifier
    ) {

        lazyPagingItems?.let {
            items(
                count = lazyPagingItems.itemCount,
                key = lazyPagingItems.itemKey(),
                contentType = lazyPagingItems.itemContentType(),
            ) { index ->
                val item = lazyPagingItems[index]
                item?.let {
                    PostCard(item)
                }
            }
        }

        posts?.let {
            items(
                posts
            ) { item ->
                PostCard(item)
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun PostListPreview() {
//    PostList(
//        listOf(
//            NewsDto(
//                title = "Title",
//                summary = "Summary",
//                chapeu = "Chapeu",
//                image = "sdsdsdsdsdsd",
//                metadata = "MetaData  - 20/01/1003",
//                aggregatedPostDtos = null,
//                url = ""
//            ), NewsDto(
//                title = "Title",
//                summary = "Summary",
//                chapeu = "Chapeu",
//                image = "sdsdsdsdsdsd",
//                metadata = "MetaData  - 20/01/1003",
//                aggregatedPostDtos = null,
//                url = ""
//            ), NewsDto(
//                title = "Title",
//                summary = "Summary",
//                chapeu = "Chapeu",
//                image = "sdsdsdsdsdsd",
//                metadata = "MetaData  - 20/01/1003",
//                aggregatedPostDtos = null,
//                url = ""
//            )
//        )
//    )
}