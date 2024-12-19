package com.paulajustino.worldinfocusapp.data.remote.newsFeed.api

import com.paulajustino.worldinfocusapp.data.remote.newsFeed.FeedResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface NewsApiService {

    // Endpoint para obter a primeira página de um feed
    @GET("feed/{path}")
    suspend fun getInitialNewsFeed(
        @Path("path", encoded = true) path: String // // encoded = true para suportar URLs no path
    ): Response<FeedResponse>

    // Endpoint para paginação do feed
    @GET("feed/page/{product}/{id}/{page}")
    suspend fun getPaginatedFeed(
        @Path("product") product: String,
        @Path("id") offerId: String,
        @Path("page") page: Int
    ): Response<FeedResponse>
}
