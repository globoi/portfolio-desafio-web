package com.paulajustino.worldinfocusapp.di

import com.paulajustino.worldinfocusapp.domain.usecase.newsFeed.GetInitialNewsFeed
import com.paulajustino.worldinfocusapp.domain.usecase.newsFeed.GetInitialNewsFeedUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    @Singleton
    abstract fun bindGetInitialNewsFeedUseCase(
        getInitialNewsFeed: GetInitialNewsFeed
    ): GetInitialNewsFeedUseCase
}