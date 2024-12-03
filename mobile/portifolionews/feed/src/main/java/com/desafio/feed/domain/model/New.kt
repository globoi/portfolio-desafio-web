package com.desafio.feed.domain.model

data class New (
    val type: String,
    val aggregatedPosts: List<AggregatedPosts>
)
