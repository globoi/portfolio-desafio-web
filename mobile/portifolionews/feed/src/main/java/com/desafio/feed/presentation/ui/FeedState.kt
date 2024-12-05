package com.desafio.feed.presentation.ui

import com.desafio.feed.domain.model.FeedNews

sealed class FeedState {
    object START : FeedState()
    object LOADING : FeedState()
    data class SUCCESS(val feedNews: FeedNews) : FeedState()
    data class FAILURE(val message: String) : FeedState()
}
