package com.paulajustino.worldinfocusapp.ui.mapper

import com.paulajustino.worldinfocusapp.domain.model.newsFeed.NewsItemModel
import com.paulajustino.worldinfocusapp.ui.model.NewsItemUiModel

interface NewsItemModelToNewsItemUiModelMapper {
    fun mapToNewsItemUiModel(from: NewsItemModel): NewsItemUiModel
}