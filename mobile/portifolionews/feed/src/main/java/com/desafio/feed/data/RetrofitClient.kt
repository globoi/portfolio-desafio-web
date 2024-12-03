package com.desafio.feed.data

import com.desafio.feed.data.service.FeedService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val BASE_URL = "https://native-leon.globo.com"

    val retrofit: Retrofit by lazy {
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    object FeedApi {
        val apiService: FeedService by lazy {
            RetrofitClient.retrofit.create(FeedService::class.java)
        }
    }
}
