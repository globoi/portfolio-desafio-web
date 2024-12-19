package com.paulajustino.worldinfocusapp.data.repository.newsFeed

import com.paulajustino.worldinfocusapp.data.local.newsFeed.NewsLocalDataSource
import com.paulajustino.worldinfocusapp.data.remote.newsFeed.NewsRemoteDataSource
import com.paulajustino.worldinfocusapp.domain.model.newsFeed.FeedModel
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