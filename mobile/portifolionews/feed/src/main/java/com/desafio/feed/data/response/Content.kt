package com.desafio.feed.data.response

data class Content(
    val chapeu: Chapeu?,
    val summary: String?,
    val title: String?,
    val image: ImageContent?,
    val url: String
)
