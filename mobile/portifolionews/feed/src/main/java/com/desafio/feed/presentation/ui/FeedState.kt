package com.desafio.feed.presentation.ui

import com.desafio.feed.domain.dto.NewsDto

sealed class FeedState {
    object START : FeedState()
    object LOADING : FeedState()
    data class SUCCESS(val feedNews: List<NewsDto>) : FeedState()
    data class FAILURE(val message: String) : FeedState()
}
