package com.paulajustino.worldinfocusapp.data.repository

import com.paulajustino.worldinfocusapp.data.local.NewsLocalDataSourceImpl
import com.paulajustino.worldinfocusapp.data.remote.NewsRemoteDataSourceImpl
import com.paulajustino.worldinfocusapp.domain.model.FeedModel
import com.paulajustino.worldinfocusapp.utils.NetworkError
import com.paulajustino.worldinfocusapp.utils.Result

class NewsRepositoryImpl : NewsRepository {

    private val remoteDataSource = NewsRemoteDataSourceImpl()
    private val localDataSource = NewsLocalDataSourceImpl()

    override suspend fun getNewsFeed(page: Int): Result<FeedModel, NetworkError> {
/*        return localDataSource.getCachedNewsFeed()?.let { cachedNewsFeed ->
            Result.Success(cachedNewsFeed)
        } ?: run {
            remoteDataSource.fetchNewsFeed(0)
        }*/
        return remoteDataSource.fetchNewsFeed(0)
    }
}