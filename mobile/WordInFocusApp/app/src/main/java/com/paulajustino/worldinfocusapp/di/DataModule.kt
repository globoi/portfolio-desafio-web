package com.paulajustino.worldinfocusapp.di

import com.paulajustino.worldinfocusapp.data.local.NewsLocalDataSource
import com.paulajustino.worldinfocusapp.data.local.NewsLocalDataSourceImpl
import com.paulajustino.worldinfocusapp.data.mapper.FeedResponseToFeedModelMapper
import com.paulajustino.worldinfocusapp.data.mapper.FeedResponseToFeedModelMapperImpl
import com.paulajustino.worldinfocusapp.data.mapper.NewsItemResponseToNewsItemModelMapper
import com.paulajustino.worldinfocusapp.data.mapper.NewsItemResponseToNewsItemModelMapperImpl
import com.paulajustino.worldinfocusapp.data.remote.NewsRemoteDataSource
import com.paulajustino.worldinfocusapp.data.remote.NewsRemoteDataSourceImpl
import com.paulajustino.worldinfocusapp.data.repository.NewsRepository
import com.paulajustino.worldinfocusapp.data.repository.NewsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindNewsRemoteDataSource(
        remoteDataSource: NewsRemoteDataSourceImpl
    ): NewsRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindNewsLocalDataSource(
        localDataSource: NewsLocalDataSourceImpl
    ): NewsLocalDataSource

    @Binds
    @Singleton
    abstract fun bindNewsRepository(
        repositoryImpl: NewsRepositoryImpl
    ): NewsRepository

    @Binds
    @Singleton
    abstract fun bindFeedResponseToFeedModelMapper(
        mapperImpl: FeedResponseToFeedModelMapperImpl
    ): FeedResponseToFeedModelMapper

    @Binds
    @Singleton
    abstract fun bindNewsItemResponseToNewsItemModelMapper(
        mapperImpl: NewsItemResponseToNewsItemModelMapperImpl
    ): NewsItemResponseToNewsItemModelMapper
}
