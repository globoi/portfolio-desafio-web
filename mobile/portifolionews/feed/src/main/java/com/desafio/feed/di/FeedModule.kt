package com.desafio.feed.di

import com.desafio.feed.data.repository.FeedRepository
import com.desafio.feed.data.repository.FeedRepositoryImpl
import com.desafio.feed.presentation.ui.dto.AggregatedPostsDto
import com.desafio.feed.presentation.ui.dto.NewsDto
import com.desafio.feed.domain.mapper.AggregatedPostsMapper
import com.desafio.feed.domain.mapper.Mapper
import com.desafio.feed.domain.mapper.NewsMapper
import com.desafio.feed.domain.model.News
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

    @Binds
    abstract fun bindNewsDtoMapper(newsMapper: NewsMapper): Mapper<News, NewsDto>

    @Binds
    abstract fun bindAggregatedPostsMapper(aggregatedPostsMapper: AggregatedPostsMapper): Mapper<News, AggregatedPostsDto>
}
