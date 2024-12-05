package com.desafio.feed.domain.model

data class News(
    val type: String,
    val content: Content?,
    val metadata: String
)
