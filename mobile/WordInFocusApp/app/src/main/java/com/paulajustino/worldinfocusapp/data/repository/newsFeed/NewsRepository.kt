package com.paulajustino.worldinfocusapp.data.repository.newsFeed

import com.paulajustino.worldinfocusapp.domain.model.newsFeed.FeedModel
import com.paulajustino.worldinfocusapp.utils.NetworkError
import com.paulajustino.worldinfocusapp.utils.Result

interface NewsRepository {
    suspend fun getNewsFeed(page: Int): Result<FeedModel, NetworkError>
}