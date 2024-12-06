package com.desafio.feed.domain.model

data class FeedNews (
    val resource: FeedResource,
    val contentType: ContentType,
    val feed: Feed
)
