package com.desafio.feed.domain.model

sealed class Size (val url: String) {
    class LargeSize(url: String) : Size(url) {
    }

}