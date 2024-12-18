package com.paulajustino.worldinfocusapp.data.remote

import com.paulajustino.worldinfocusapp.domain.model.FeedModel
import com.paulajustino.worldinfocusapp.utils.NetworkError
import com.paulajustino.worldinfocusapp.utils.Result

interface NewsRemoteDataSource {
    suspend fun fetchNewsFeed(page: Int): Result<FeedModel, NetworkError>
}