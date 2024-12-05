package com.desafio.feed.data.di

import com.desafio.feed.data.service.FeedService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RestModule {

    @Provides
    fun provideBaseUrl() = "https://native-leon.globo.com"

    @Singleton
    @Provides
    fun provideRetrofit(baseUrl: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideFeedService(retrofit: Retrofit) = retrofit.create(FeedService::class.java)
}