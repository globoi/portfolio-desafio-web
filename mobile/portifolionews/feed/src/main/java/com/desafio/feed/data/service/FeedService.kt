package com.desafio.feed.data.service

import com.desafio.feed.data.response.NetworkResponse
import com.desafio.feed.domain.model.FeedNews
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface FeedService {

    @GET("/feed/g1")
    suspend fun fetchFirstPageFeed(): Response<FeedNews>

    @GET("/feed/page/{product}/{id}/{page}")
    suspend fun fetchNextPageFeed(
        @Path("product")
        product: String,
        @Path("page")
        nextPage: Int,
        @Path("id")
        id: String
    ): Response<FeedNews>

}
