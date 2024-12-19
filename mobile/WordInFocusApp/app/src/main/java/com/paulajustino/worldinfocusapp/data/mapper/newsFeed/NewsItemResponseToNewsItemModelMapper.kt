package com.paulajustino.worldinfocusapp.data.mapper.newsFeed

import com.paulajustino.worldinfocusapp.domain.model.newsFeed.NewsItemModel
import com.paulajustino.worldinfocusapp.data.remote.newsFeed.NewsItemResponse

interface NewsItemResponseToNewsItemModelMapper {
    fun mapToNewsItemModel(from: NewsItemResponse): NewsItemModel
}