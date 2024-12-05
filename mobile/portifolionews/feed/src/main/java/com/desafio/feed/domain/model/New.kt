package com.desafio.feed.domain.model

data class New(
    val type: String,
    val publication: String,
    val content: NewContent?
)
