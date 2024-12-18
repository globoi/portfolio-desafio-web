package com.paulajustino.worldinfocusapp.data.repository

import com.paulajustino.worldinfocusapp.data.local.NewsLocalDataSource
import com.paulajustino.worldinfocusapp.data.remote.NewsRemoteDataSource
import com.paulajustino.worldinfocusapp.domain.model.FeedModel
import com.paulajustino.worldinfocusapp.utils.NetworkError
import com.paulajustino.worldinfocusapp.utils.Result
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val remoteDataSource: NewsRemoteDataSource,
    private val localDataSource: NewsLocalDataSource
) : NewsRepository {
    override suspend fun getNewsFeed(page: Int): Result<FeedModel, NetworkError> {
        /*        return localDataSource.getCachedNewsFeed()?.let { cachedNewsFeed ->
                    Result.Success(cachedNewsFeed)
                } ?: run {
                    remoteDataSource.fetchNewsFeed(0)
                }*/
        return remoteDataSource.fetchNewsFeed(0)
    }
}