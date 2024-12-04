package com.desafio.feed.data.repository

import com.desafio.feed.data.RetrofitClient
import com.desafio.feed.data.service.FeedService
import com.desafio.feed.domain.model.Feed
import javax.inject.Inject

interface FeedRepository {
    suspend fun getFeed(): Feed
}

class FeedRepositoryImpl @Inject constructor(
    private val feedService: FeedService
) : FeedRepository {

    override suspend fun getFeed(): Feed {
        return feedService.fetchFeed()
    }
}
