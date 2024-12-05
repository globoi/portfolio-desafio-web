package com.desafio.feed.domain.model

data class Content(
    val chapeu: Chapeu?,
    val summary: String,
    val title: String?,
    val imageInfo: ImageInfo?,
    val url: String
)
