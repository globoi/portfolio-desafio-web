package com.desafio.feed.domain.model

data class News(
    val type: String,
    val content: Content?,
    val aggregatedPosts: List<News>?,
    val metadata: String
)
