package com.paulajustino.worldinfocusapp.data.remote.newsFeed

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsFeedResponse(
    @Json(name = "feed") val feed: NewsFeedDetailsResponse
)

@JsonClass(generateAdapter = true)
data class NewsFeedDetailsResponse(
    @Json(name = "oferta") val oferta: String?,
    @Json(name = "falkor") val falkor: FalkorResponse
)

@JsonClass(generateAdapter = true)
data class FalkorResponse(
    @Json(name = "items") val items: List<NewsItemResponse>,
    @Json(name = "nextPage") val nextPage: Int
)

@JsonClass(generateAdapter = true)
data class NewsItemResponse(
    @Json(name = "id") val id: String,
    @Json(name = "type") val type: String,
    @Json(name = "metadata") val metadata: String?,
    @Json(name = "content") val content: NewsItemContentResponse?
)

@JsonClass(generateAdapter = true)
data class NewsItemContentResponse(
    @Json(name = "chapeu") val subSection: SubSectionResponse?,
    @Json(name = "title") val title: String?,
    @Json(name = "summary") val summary: String?,
    @Json(name = "section") val section: String?,
    @Json(name = "url") val url: String?,
    @Json(name = "image") val image: ImageResponse?
)

@JsonClass(generateAdapter = true)
data class SubSectionResponse(
    @Json(name = "label") val label: String?
)

@JsonClass(generateAdapter = true)
data class ImageResponse(
    @Json(name = "sizes") val sizes: ImageSizesResponse?
)

@JsonClass(generateAdapter = true)
data class ImageSizesResponse(
    @Json(name = "S") val small: ImageSizeResponse?,
    @Json(name = "L") val large: ImageSizeResponse?,
    @Json(name = "M") val medium: ImageSizeResponse?
)

@JsonClass(generateAdapter = true)
data class ImageSizeResponse(
    @Json(name = "url") val url: String?,
    @Json(name = "height") val height: Int?,
    @Json(name = "width") val width: Int?
)