package com.desafio.feed.domain.mapper

import com.desafio.feed.domain.dto.NewsDto
import com.desafio.feed.domain.model.News

class NewsMapper: Mapper<News, NewsDto> {
    override fun map(input: News): NewsDto {
        return NewsDto(
            title = input.content!!.title!!,
            summary = input.content.summary,
            chapeu = input.content.chapeu?.label ?: "",
            image = "",
            metadata = ""
        )
    }
}