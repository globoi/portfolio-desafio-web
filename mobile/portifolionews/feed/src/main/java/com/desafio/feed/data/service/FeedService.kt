package com.desafio.feed.data.service

import com.desafio.feed.domain.model.FeedNews
import retrofit2.http.GET

interface FeedService {

    @GET("/feed/g1")
    suspend fun fetchFeed(): FeedNews
}
