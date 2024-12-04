package com.desafio.feed.presentation.ui

import com.desafio.feed.domain.model.Feed

sealed class FeedState {
    object START : FeedState()
    object LOADING : FeedState()
    data class SUCCESS(val feed: Feed) : FeedState()
    data class FAILURE(val message: String) : FeedState()
}
