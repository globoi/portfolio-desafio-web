package com.paulajustino.worldinfocusapp.domain.model

/**
 * Modelo de dados de uma notícia.
 */
data class NewsItem(
    val id: String,
    val title: String,
    val description: String,
    val type: String,
    val chapeu: String?,
    val metadata: String,
    val url: String
)