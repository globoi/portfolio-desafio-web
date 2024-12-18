package com.paulajustino.worldinfocusapp.data.mapper

import com.paulajustino.worldinfocusapp.domain.model.NewsItemModel
import com.paulajustino.worldinfocusapp.data.remote.api.ImageResponse
import com.paulajustino.worldinfocusapp.data.remote.api.NewsItemResponse

class NewsItemResponseToNewsItemModelMapperImpl : NewsItemResponseToNewsItemModelMapper {
    override fun mapToNewsItemModel(from: NewsItemResponse): NewsItemModel {
        return NewsItemModel(
            id = from.id,
            type = from.type,
            chapeu = from.content?.chapeu?.label.orEmpty(),
            title = from.content?.title.orEmpty(),
            summary = from.content?.summary,
            imageUrl = getImageUrl(from.content?.image),
            section = from.content?.section,
            metaData = from.metadata.orEmpty(),
            url = from.content?.url.orEmpty()
        )
    }

    private fun getImageUrl(imageResponse: ImageResponse?): String? {
        return imageResponse?.sizes?.small?.url
    }
}