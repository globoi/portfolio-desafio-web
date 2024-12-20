package com.paulajustino.worldinfocusapp.di

import com.paulajustino.worldinfocusapp.data.local.menu.MenuLocalDataSource
import com.paulajustino.worldinfocusapp.data.local.menu.MenuLocalDataSourceImpl
import com.paulajustino.worldinfocusapp.data.mapper.menu.MenuItemResponseToMenuItemModelMapper
import com.paulajustino.worldinfocusapp.data.mapper.menu.MenuItemResponseToMenuItemModelMapperImpl
import com.paulajustino.worldinfocusapp.data.mapper.menu.MenuResponseToMenuModelMapper
import com.paulajustino.worldinfocusapp.data.mapper.menu.MenuResponseToMenuModelMapperImpl
import com.paulajustino.worldinfocusapp.data.mapper.newsFeed.FeedResponseToFeedModelMapper
import com.paulajustino.worldinfocusapp.data.mapper.newsFeed.FeedResponseToFeedModelMapperImpl
import com.paulajustino.worldinfocusapp.data.mapper.newsFeed.NewsItemResponseToNewsItemModelMapper
import com.paulajustino.worldinfocusapp.data.mapper.newsFeed.NewsItemResponseToNewsItemModelMapperImpl
import com.paulajustino.worldinfocusapp.data.remote.newsFeed.NewsRemoteDataSource
import com.paulajustino.worldinfocusapp.data.remote.newsFeed.NewsRemoteDataSourceImpl
import com.paulajustino.worldinfocusapp.data.repository.menu.MenuRepository
import com.paulajustino.worldinfocusapp.data.repository.menu.MenuRepositoryImpl
import com.paulajustino.worldinfocusapp.data.repository.newsFeed.NewsFeedRepository
import com.paulajustino.worldinfocusapp.data.repository.newsFeed.NewsFeedRepositoryImpl
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
        newsRemoteDataSource: NewsRemoteDataSourceImpl
    ): NewsRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindNewsFeedRepository(
        newsFeedRepository: NewsFeedRepositoryImpl
    ): NewsFeedRepository

    @Binds
    @Singleton
    abstract fun bindFeedResponseToFeedModelMapper(
        feedMapper: FeedResponseToFeedModelMapperImpl
    ): FeedResponseToFeedModelMapper

    @Binds
    @Singleton
    abstract fun bindNewsItemResponseToNewsItemModelMapper(
        newsItemMapper: NewsItemResponseToNewsItemModelMapperImpl
    ): NewsItemResponseToNewsItemModelMapper

    @Binds
    @Singleton
    abstract fun bindMenuLocalDataSource(
        menuLocalDataSource: MenuLocalDataSourceImpl
    ): MenuLocalDataSource

    @Binds
    @Singleton
    abstract fun bindMenuRepository(
        menuRepository: MenuRepositoryImpl
    ): MenuRepository

    @Binds
    @Singleton
    abstract fun bindMenuResponseToMenuModelMapper(
        menuMapper: MenuResponseToMenuModelMapperImpl
    ): MenuResponseToMenuModelMapper

    @Binds
    @Singleton
    abstract fun bindMenuItemResponseToMenuItemModelMapper(
        menuItemMapper: MenuItemResponseToMenuItemModelMapperImpl
    ): MenuItemResponseToMenuItemModelMapper
}
