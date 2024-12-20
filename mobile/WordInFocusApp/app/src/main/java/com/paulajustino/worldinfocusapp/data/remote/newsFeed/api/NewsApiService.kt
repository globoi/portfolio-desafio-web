package com.paulajustino.worldinfocusapp.data.remote.newsFeed.api

import com.paulajustino.worldinfocusapp.data.remote.newsFeed.NewsFeedResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface NewsApiService {

    // Endpoint para obter a primeira página do feed
    @GET("feed/{path}")
    suspend fun getInitialNewsFeed(
        @Path("path", encoded = true) path: String // encoded = true para suportar URLs no path
    ): Response<NewsFeedResponse>

/*    // Endpoint para paginação do feed
    @GET("feed/page/{product}/{id}/{page}")
    suspend fun getNextNewsFeed(
        @Path("product") product: String,
        @Path("id") offerId: String,
        @Path("page") page: Int
    ): Response<NewsFeedResponse>*/
}
