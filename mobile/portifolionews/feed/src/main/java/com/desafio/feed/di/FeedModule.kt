package com.desafio.feed.di

import com.desafio.feed.data.repository.FeedRepository
import com.desafio.feed.data.repository.FeedRepositoryImpl
import com.desafio.feed.domain.usecase.FeedUseCase
import com.desafio.feed.domain.usecase.FeedUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FeedModule {

    @Binds
    abstract fun bindFeedRepository(feedRepositoryImpl: FeedRepositoryImpl): FeedRepository

    @Binds
    abstract fun bindFeedUseCase(feedUseCaseImpl: FeedUseCaseImpl): FeedUseCase


}
