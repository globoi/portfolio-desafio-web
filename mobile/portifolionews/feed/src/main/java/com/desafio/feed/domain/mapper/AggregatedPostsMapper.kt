package com.desafio.feed.domain.mapper

import com.desafio.feed.domain.dto.AggregatedPostsDto
import com.desafio.feed.domain.model.News
import javax.inject.Inject

class AggregatedPostsMapper @Inject constructor(): Mapper<News, AggregatedPostsDto> {
    override fun map(input: News): AggregatedPostsDto {
        return AggregatedPostsDto(
            title = input.content?.title ?: "",
            summary = input.content?.summary ?: "",
            url = input.content?.url ?: ""
        )
    }
}