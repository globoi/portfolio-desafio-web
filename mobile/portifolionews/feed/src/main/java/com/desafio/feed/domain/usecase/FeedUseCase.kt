package com.desafio.feed.domain.usecase

import com.desafio.feed.data.repository.FeedRepository
import com.desafio.feed.domain.model.FeedNews
import javax.inject.Inject

interface FeedUseCase {
    suspend fun fetchFeed(): FeedNews
}

class FeedUseCaseImpl @Inject constructor(
    private val feedRepository: FeedRepository
) : FeedUseCase {
    override suspend fun fetchFeed() : FeedNews {
        val feed = feedRepository.getFeed()
        return feed
    }
}
