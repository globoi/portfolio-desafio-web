package com.paulajustino.worldinfocusapp.data.remote

import android.util.Log
import com.paulajustino.worldinfocusapp.data.mapper.FeedResponseToFeedModelMapperImpl
import com.paulajustino.worldinfocusapp.data.mapper.NewsItemResponseToNewsItemModelMapperImpl
import com.paulajustino.worldinfocusapp.data.remote.api.NewsApiService
import com.paulajustino.worldinfocusapp.data.remote.api.RetrofitInstance
import com.paulajustino.worldinfocusapp.domain.model.FeedModel
import com.paulajustino.worldinfocusapp.utils.NetworkError
import com.paulajustino.worldinfocusapp.utils.Result

class NewsRemoteDataSourceImpl : NewsRemoteDataSource {
    private val feedMapper =
        FeedResponseToFeedModelMapperImpl(NewsItemResponseToNewsItemModelMapperImpl())
    private val apiService = RetrofitInstance.retrofit.create(NewsApiService::class.java)

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