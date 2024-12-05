package com.desafio.feed.domain.usecase

import com.desafio.feed.data.repository.FeedRepository
import com.desafio.feed.domain.dto.NewsDto
import com.desafio.feed.domain.mapper.Mapper
import com.desafio.feed.domain.mapper.NewsMapper
import com.desafio.feed.domain.model.FeedNews
import com.desafio.feed.domain.model.News
import javax.inject.Inject

interface FeedUseCase {
    suspend fun fetchFeed(): List<NewsDto>
}

class FeedUseCaseImpl @Inject constructor(
    private val feedRepository: FeedRepository,
    private val newsMapper: Mapper<News, NewsDto>
) : FeedUseCase {
    override suspend fun fetchFeed() : List<NewsDto> {
        val feed = feedRepository.getFeed()

        val posts = feed.feed.falkor.items.filter { post ->
            post.type == "materia" || post.type == "basico"
        }

        return posts.map {
            newsMapper.map(it)
        }
    }
}
