package com.desafio.feed.domain.model

data class NewContent  (
    val section: String,
    val summary: String,
    val title: String,
    val image: ImageInfo,
    val url: String
)
