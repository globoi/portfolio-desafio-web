package com.desafio.feed.presentation.ui

import com.desafio.feed.presentation.ui.dto.FeedDTO
import com.desafio.feed.presentation.ui.dto.NewsDto

sealed class FeedState {
    object START : FeedState()
    object LOADING : FeedState()
    data class SUCCESS(val feedDTO: FeedDTO) : FeedState()
    data class FETCH(val feedNews: List<NewsDto>) : FeedState()
    data class FAILURE(val message: String) : FeedState()
}