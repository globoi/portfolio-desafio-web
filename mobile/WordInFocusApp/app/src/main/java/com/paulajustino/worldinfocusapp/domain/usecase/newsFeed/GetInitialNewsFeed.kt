package com.paulajustino.worldinfocusapp.domain.usecase.newsFeed

import com.paulajustino.worldinfocusapp.data.repository.newsFeed.NewsFeedRepository
import com.paulajustino.worldinfocusapp.ui.mapper.NewsItemModelToNewsItemUiModelMapper
import com.paulajustino.worldinfocusapp.ui.model.NewsItemUiModel
import com.paulajustino.worldinfocusapp.utils.Constants
import com.paulajustino.worldinfocusapp.utils.NetworkError
import com.paulajustino.worldinfocusapp.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetInitialNewsFeed @Inject constructor(
    private val newsFeedRepository: NewsFeedRepository,
    private val newsItemUiModelMapper: NewsItemModelToNewsItemUiModelMapper
) : GetInitialNewsFeedUseCase {
    override suspend fun getInitialNewsFeed(newsType: String): Result<List<NewsItemUiModel>, NetworkError> {
        return withContext(Dispatchers.IO) {
            val feedModelReturn = async { newsFeedRepository.getInitialNewsFeed(newsType) }.await()
            if (feedModelReturn is Result.Success) {
                val filteredNews =
                    feedModelReturn.data.news.filter {
                        it.type in listOf(
                            Constants.BASIC_NEWS_TYPE,
                            Constants.MATERIAL_NEWS_TYPE
                        )
                    }
                val newsItemUiModels =
                    filteredNews.map { newsItemUiModelMapper.mapToNewsItemUiModel(it) }
                return@withContext Result.Success(newsItemUiModels)
            } else {
                return@withContext Result.Error((feedModelReturn as Result.Error).error)
            }
        }
    }
}