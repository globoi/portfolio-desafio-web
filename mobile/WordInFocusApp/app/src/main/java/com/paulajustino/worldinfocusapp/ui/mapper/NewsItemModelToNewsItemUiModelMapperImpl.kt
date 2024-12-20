package com.paulajustino.worldinfocusapp.ui.mapper

import com.paulajustino.worldinfocusapp.domain.model.newsFeed.NewsItemModel
import com.paulajustino.worldinfocusapp.ui.model.NewsItemUiModel
import javax.inject.Inject

class NewsItemModelToNewsItemUiModelMapperImpl @Inject constructor() :
    NewsItemModelToNewsItemUiModelMapper {
    override fun mapToNewsItemUiModel(from: NewsItemModel): NewsItemUiModel {
        return NewsItemUiModel(
            id = from.id,
            type = from.type,
            title = from.title,
            summary = from.summary,
            imageUrl = from.imageUrl,
            subSection = from.subSection,
            metaData = from.metaData,
            url = from.url
        )
    }
}