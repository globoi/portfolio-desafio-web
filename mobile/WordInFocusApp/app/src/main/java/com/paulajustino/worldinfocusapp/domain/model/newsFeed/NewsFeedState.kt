package com.paulajustino.worldinfocusapp.domain.model.newsFeed

import com.paulajustino.worldinfocusapp.ui.model.NewsItemUiModel

sealed class NewsFeedState {
    data object Loading : NewsFeedState()
    data class Success(val news: List<NewsItemUiModel>) : NewsFeedState()
    data class Error(val message: String) : NewsFeedState()
}