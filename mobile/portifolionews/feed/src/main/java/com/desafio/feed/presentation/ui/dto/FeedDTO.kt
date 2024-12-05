package com.desafio.feed.presentation.ui.dto

data class FeedDTO (
    val postList: List<NewsDto>,
    val oferta: String,
    val nextPage: Int
)
