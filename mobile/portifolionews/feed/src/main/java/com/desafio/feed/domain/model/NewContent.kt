package com.desafio.feed.domain.model

data class NewContent  (
    val chapeu: Chapeu,
    val summary: String,
    val title: String?,
    val url: String
)
