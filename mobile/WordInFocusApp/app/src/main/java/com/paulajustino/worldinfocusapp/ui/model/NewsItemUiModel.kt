package com.paulajustino.worldinfocusapp.ui.model

data class NewsItemUiModel(
    val id: String,
    val type: String,
    val title: String?,
    val summary: String?,
    val imageUrl: String?,
    val subSection: String?,
    val metaData: String?,
    val url: String?
)