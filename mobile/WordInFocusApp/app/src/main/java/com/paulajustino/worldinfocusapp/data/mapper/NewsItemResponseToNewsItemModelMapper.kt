package com.paulajustino.worldinfocusapp.data.mapper

import com.paulajustino.worldinfocusapp.domain.model.NewsItemModel
import com.paulajustino.worldinfocusapp.data.remote.api.NewsItemResponse

interface NewsItemResponseToNewsItemModelMapper {
    fun mapToNewsItemModel(from: NewsItemResponse): NewsItemModel
}