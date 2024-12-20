package com.paulajustino.worldinfocusapp.data.remote.newsFeed

import com.paulajustino.worldinfocusapp.data.mapper.newsFeed.FeedResponseToFeedModelMapper
import com.paulajustino.worldinfocusapp.data.remote.newsFeed.api.NewsApiService
import com.paulajustino.worldinfocusapp.domain.model.newsFeed.FeedModel
import com.paulajustino.worldinfocusapp.utils.Constants
import com.paulajustino.worldinfocusapp.utils.NetworkError
import com.paulajustino.worldinfocusapp.utils.NewsType
import com.paulajustino.worldinfocusapp.utils.Result
import javax.inject.Inject

class NewsRemoteDataSourceImpl @Inject constructor(
    private val apiService: NewsApiService,
    private val feedMapper: FeedResponseToFeedModelMapper
) : NewsRemoteDataSource {
    override suspend fun fetchInitialNewsFeed(newsType: String): Result<FeedModel, NetworkError> {
        return try {
            val path = getProductOrPathByNewsType(newsType)
            val response = apiService.getInitialNewsFeed(path)

            if (response.isSuccessful) {
                response.body()?.let {
                    val data = feedMapper.mapToFeedModel(it)
                    Result.Success(data)
                } ?: Result.Error(NetworkError("Erro inesperado: resposta vazia"))
            } else {
                Result.Error(NetworkError("Erro na resposta da API: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.Error(NetworkError("Erro de conexão ou inesperado: ${e.localizedMessage}"))
        }
    }

    private fun getProductOrPathByNewsType(newsType: String): String {
        return when (newsType) {
            NewsType.RECENTS.type -> Constants.PRODUCT_RECENTS_NEWS
            NewsType.AGRO.type -> Constants.URL_AGRO_NEWS
            else -> ""
        }
    }
}

/*  override suspend fun fetchPagedNewsFeed(
    newsType: String,
    offerId: String?,
    page: Int
): Result<FeedModel, NetworkError> {
    return try {
        val product = getProductOrPathByNewsType(newsType)

        val response: Response<NewsFeedResponse> = when {
            page == 1 -> apiService.getInitialNewsFeed(product)
            page > 1 && !offerId.isNullOrBlank() -> apiService.getNextNewsFeed(product, offerId, page)
        }

        if (response.isSuccessful) {
            response.body()?.let {
                val data = feedMapper.mapToFeedModel(it)
                Result.Success(data)
            } ?: Result.Error(NetworkError("Resposta vazia"))
        } else {
            Result.Error(NetworkError("Erro na API: ${response.code()}"))
        }
    } catch (e: Exception) {
        Result.Error(NetworkError("Erro de conexão ou inesperado: ${e.localizedMessage}"))
    }
}


class NewsFeedPagingSource(
    private val remoteDataSource: NewsRemoteDataSource,
    private val newsType: String,
    private val nextPage: Int,
    private val offerId: String?
) : PagingSource<Int, NewsItemModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsItemModel> {
        val page = params.key ?: nextPage

        return try {
            when (val result = remoteDataSource.fetchPagedNewsFeed(newsType, offerId, page)) {
                is Result.Success -> {
                    val newsFeed = result.data

                    LoadResult.Page(
                        data = newsFeed.news,
                        prevKey = null,
                        nextKey = newsFeed.nextPage
                    )
                }

                is Result.Error -> {
                    LoadResult.Error(Exception("Erro na resposta da API: ${result.error.message}"))
                }
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, NewsItemModel>): Int? {
        return state.anchorPosition?.let { anchor ->
            state.closestPageToPosition(anchor)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchor)?.nextKey?.minus(1)
        }
    }
}
*/