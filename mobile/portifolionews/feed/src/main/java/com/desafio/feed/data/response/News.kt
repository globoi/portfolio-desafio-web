package com.desafio.feed.data.response

data class News(
    val type: String,
    val content: Content?,
    val aggregatedPosts: List<News>?,
    val metadata: String
)
