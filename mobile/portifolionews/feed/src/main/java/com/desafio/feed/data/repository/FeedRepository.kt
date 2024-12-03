package com.desafio.feed.data.repository

import com.desafio.feed.domain.model.New

interface FeedRepository {
    suspend fun getFeed(): List<New>
}

class FeedRepositoryImpl (): FeedRepository {

    override suspend fun getFeed(): List<New> {
        TODO("Not yet implemented")
    }
}
