package com.paulajustino.worldinfocusapp.data.remote

import com.paulajustino.worldinfocusapp.data.mapper.FeedResponseToFeedModelMapper
import com.paulajustino.worldinfocusapp.data.remote.api.NewsApiService
import com.paulajustino.worldinfocusapp.domain.model.FeedModel
import com.paulajustino.worldinfocusapp.utils.NetworkError
import com.paulajustino.worldinfocusapp.utils.Result
import javax.inject.Inject

class NewsRemoteDataSourceImpl @Inject constructor(
    private val apiService: NewsApiService,
    private val feedMapper: FeedResponseToFeedModelMapper
) : NewsRemoteDataSource {
    override suspend fun fetchNewsFeed(page: Int): Result<FeedModel, NetworkError> {
        return try {
            val response = apiService.getInitialNewsFeed("g1")

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
}