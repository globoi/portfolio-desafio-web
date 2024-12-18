package com.paulajustino.worldinfocusapp.domain.model

/**
 * Estado do Feed da aplicação.
 * Pode ser um estado de carregamento, sucesso ou erro.
 */
sealed class FeedState {
    data class Loading(val isRefreshing: Boolean) : FeedState()
    data class Success(val news: List<NewsItem>) : FeedState()
    data class Error(val message: String) : FeedState()
}