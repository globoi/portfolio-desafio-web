package com.desafio.feed.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.desafio.feed.data.paging.NewsPagingSource
import com.desafio.feed.data.response.NetworkResponse
import com.desafio.feed.data.response.handleApi
import com.desafio.feed.data.service.FeedService
import com.desafio.feed.data.response.FeedNews
import com.desafio.feed.data.response.News
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface FeedRepository {
    suspend fun getFirstPageFeed(content: String): NetworkResponse<FeedNews>
    fun getNextPage(product: String,  id: String): Flow<PagingData<News>>
}

class FeedRepositoryImpl @Inject constructor(
    private val feedService: FeedService
) : FeedRepository {

    override suspend fun getFirstPageFeed(content: String): NetworkResponse<FeedNews> =
        handleApi { feedService.fetchFirstPageFeed(content) }

    override fun getNextPage(
        product: String,
        id: String
    ): Flow<PagingData<News>> {
        return Pager(
            config = PagingConfig(
                20
            ),
            pagingSourceFactory = {
                NewsPagingSource(feedService, product, id)
            }
        ).flow
    }
}
