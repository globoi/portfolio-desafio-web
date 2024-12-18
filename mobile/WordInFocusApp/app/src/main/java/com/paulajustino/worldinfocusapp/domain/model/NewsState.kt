package com.paulajustino.worldinfocusapp.domain.model

/**
 * Estado das noticias.
 * Pode ser um estado de carregamento, sucesso ou erro.
 */
sealed class NewsState {
    data class Loading(val isRefreshing: Boolean) : NewsState()
    data class Success(val news: List<NewsItem>) : NewsState()
    data class Error(val message: String) : NewsState()
}