package com.paulajustino.worldinfocusapp.data.mapper

import com.paulajustino.worldinfocusapp.domain.model.FeedModel
import com.paulajustino.worldinfocusapp.data.remote.api.FeedResponse
import javax.inject.Inject

class FeedResponseToFeedModelMapperImpl @Inject constructor(
    private val newsItemMapper: NewsItemResponseToNewsItemModelMapper
) : FeedResponseToFeedModelMapper {
    override fun mapToFeedModel(from: FeedResponse): FeedModel {
        val news = from.feed.falkor.items.map { newsItemMapper.mapToNewsItemModel(it) }
        return FeedModel(
            news = news,
            nextPage = from.feed.falkor.nextPage,
            oferta = from.feed.oferta
        )
    }
}