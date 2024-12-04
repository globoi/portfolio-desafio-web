package com.desafio.feed.domain.usecase

import com.desafio.feed.data.repository.FeedRepository
import com.desafio.feed.domain.model.Feed
import javax.inject.Inject

interface FeedUseCase {
    suspend fun fetchFeed(): Feed
}

class FeedUseCaseImpl @Inject constructor(
    private val feedRepository: FeedRepository
) : FeedUseCase {
    override suspend fun fetchFeed() : Feed {
        val feed = feedRepository.getFeed()
        return feed
    }
}
