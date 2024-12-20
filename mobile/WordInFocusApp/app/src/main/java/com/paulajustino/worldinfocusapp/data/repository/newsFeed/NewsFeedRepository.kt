package com.paulajustino.worldinfocusapp.data.repository.newsFeed

import com.paulajustino.worldinfocusapp.domain.model.newsFeed.FeedModel
import com.paulajustino.worldinfocusapp.utils.NetworkError
import com.paulajustino.worldinfocusapp.utils.Result

interface NewsFeedRepository {
    suspend fun getInitialNewsFeed(newsType: String): Result<FeedModel, NetworkError>
    //suspend fun getPagedNewsFeed(newsType: String, page: Int, offerId: String?): Flow<PagingData<NewsItemModel>>
}