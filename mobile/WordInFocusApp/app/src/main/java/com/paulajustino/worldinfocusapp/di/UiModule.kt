package com.paulajustino.worldinfocusapp.di

import com.paulajustino.worldinfocusapp.ui.mapper.NewsItemModelToNewsItemUiModelMapper
import com.paulajustino.worldinfocusapp.ui.mapper.NewsItemModelToNewsItemUiModelMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UiModule {

    @Binds
    @Singleton
    abstract fun bindNewsItemModelToNewsItemUiModelMapper(
        newsItemUiModelMapper: NewsItemModelToNewsItemUiModelMapperImpl
    ): NewsItemModelToNewsItemUiModelMapper
}