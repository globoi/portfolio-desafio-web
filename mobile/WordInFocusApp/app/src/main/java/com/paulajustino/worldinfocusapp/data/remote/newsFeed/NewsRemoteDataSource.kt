package com.paulajustino.worldinfocusapp.data.remote.newsFeed

import com.paulajustino.worldinfocusapp.domain.model.newsFeed.FeedModel
import com.paulajustino.worldinfocusapp.utils.NetworkError
import com.paulajustino.worldinfocusapp.utils.Result

interface NewsRemoteDataSource {
    suspend fun fetchInitialNewsFeed(newsType: String): Result<FeedModel, NetworkError>
/*    suspend fun fetchPagedNewsFeed(
        newsType: String,
        offerId: String?,
        page: Int
    ): Result<FeedModel, NetworkError>*/
}