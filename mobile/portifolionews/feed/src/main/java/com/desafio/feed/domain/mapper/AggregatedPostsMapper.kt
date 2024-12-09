package com.desafio.feed.domain.mapper

import com.desafio.feed.presentation.ui.dto.AggregatedPostsDto
import com.desafio.feed.data.response.News
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