package com.desafio.feed.domain.model

data class Content (
    val title: String,
    val summary: String,
    val url: String,
    val chapeu: Chapeu?,
    val image: Image
)
