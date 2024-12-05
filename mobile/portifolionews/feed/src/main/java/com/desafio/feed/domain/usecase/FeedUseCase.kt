package com.desafio.feed.domain.usecase

import androidx.paging.PagingData
import androidx.paging.map
import com.desafio.feed.data.repository.FeedRepository
import com.desafio.feed.data.response.NetworkResponse
import com.desafio.feed.domain.mapper.Mapper
import com.desafio.feed.domain.model.News
import com.desafio.feed.presentation.ui.dto.FeedDTO
import com.desafio.feed.presentation.ui.dto.NewsDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface FeedUseCase {
    suspend fun fetchFeed(): FeedDTO
    fun fetchNextPage(
        product: String,
        id: String
    ): Flow<PagingData<NewsDto>>
}

class FeedUseCaseImpl @Inject constructor(
    private val feedRepository: FeedRepository,
    private val newsMapper: Mapper<News, NewsDto>
) : FeedUseCase {
    override suspend fun fetchFeed(): FeedDTO {
       return when (val response = feedRepository.getFirstPageFeed()) {
            is NetworkResponse.Error -> {
                FeedDTO(
                    postList = listOf(),
                    oferta = "",
                    nextPage = 1
                )
            }

            is NetworkResponse.Success -> {
                val posts = response.value.feed.falkor.items.filter {
                    it.type == "materia" || it.type == "basico"
                }

                val items = posts.map {
                    newsMapper.map(it)
                }

                FeedDTO(
                    postList = items,
                    oferta = response.value.feed.oferta,
                    nextPage = response.value.feed.falkor.nextPage
                )
            }
        }
    }

    override fun fetchNextPage(
        product: String,
        id: String
    ): Flow<PagingData<NewsDto>> {
        return feedRepository.getNextPage(
            product = product,
            id = id
        ).map { pagingData ->
            pagingData.map { news ->
                newsMapper.map(news)
            }
        }
    }
}
