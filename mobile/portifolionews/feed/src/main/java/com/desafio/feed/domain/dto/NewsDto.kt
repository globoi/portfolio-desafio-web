package com.desafio.feed.domain.dto

data class NewsDto  (
    val title: String,
    val summary: String,
    val chapeu: String,
    val image: String?,
    val metadata: String,
    val url: String,
    val aggregatedPostDtos: List<AggregatedPostsDto>?
)
