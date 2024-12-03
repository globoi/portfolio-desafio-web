package com.desafio.feed.data.repository

import com.desafio.feed.data.RetrofitClient
import com.desafio.feed.domain.model.Feed

interface FeedRepository {
    suspend fun getFeed(): Feed
}

class FeedRepositoryImpl: FeedRepository {

    override suspend fun getFeed(): Feed {
        return RetrofitClient.FeedApi.apiService.fetchFeed()
    }
}
