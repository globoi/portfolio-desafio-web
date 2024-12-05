package com.desafio.feed.data.repository

import com.desafio.feed.data.service.FeedService
import com.desafio.feed.domain.model.FeedNews
import javax.inject.Inject

interface FeedRepository {
    suspend fun getFeed(): FeedNews
}

class FeedRepositoryImpl @Inject constructor(
    private val feedService: FeedService
) : FeedRepository {

    override suspend fun getFeed(): FeedNews {
        return feedService.fetchFeed()
    }
}
