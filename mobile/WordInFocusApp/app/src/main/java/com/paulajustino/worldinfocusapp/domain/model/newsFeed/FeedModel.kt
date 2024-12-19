package com.paulajustino.worldinfocusapp.domain.model.newsFeed

data class FeedModel(
    val news: List<NewsItemModel>,
    val nextPage: Int,
    val oferta: String
)

data class NewsItemModel(
    val id: String,
    val type: String,
    val chapeu: String?,
    val title: String,
    val summary: String?,
    val imageUrl: String?,
    val section: String?,
    val metaData: String?,
    val url: String
)
