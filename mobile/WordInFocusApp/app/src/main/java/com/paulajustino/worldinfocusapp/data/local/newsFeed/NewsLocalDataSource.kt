package com.paulajustino.worldinfocusapp.data.local.newsFeed

import com.paulajustino.worldinfocusapp.domain.model.newsFeed.FeedModel

interface NewsLocalDataSource {
    suspend fun getCachedNewsFeed(): FeedModel?
    suspend fun saveNewsFeed(newsFeed: FeedModel)
}