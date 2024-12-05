package com.desafio.feed.domain.mapper

import com.desafio.feed.presentation.ui.dto.AggregatedPostsDto
import com.desafio.feed.presentation.ui.dto.NewsDto
import com.desafio.feed.domain.model.News
import javax.inject.Inject

class NewsMapper @Inject constructor(
    val aggregatedPostsMapper: Mapper<News, AggregatedPostsDto>
) : Mapper<News, NewsDto> {
    override fun map(input: News): NewsDto {
        return NewsDto(
            title = input.content?.title ?: "",
            summary = input.content?.summary ?: "",
            chapeu = input.content?.chapeu?.label ?: "",
            image = input.content?.image?.sizes?.S?.url,
            metadata = input.metadata,
            aggregatedPostDtos = input.aggregatedPosts?.let {
                it.map { post ->
                    aggregatedPostsMapper.map(post)
                }
            },
            url = input.content?.url ?: ""
        )
    }
}