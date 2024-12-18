package com.paulajustino.worldinfocusapp.data.local

import com.paulajustino.worldinfocusapp.domain.model.FeedModel

interface NewsLocalDataSource {
    suspend fun getCachedNewsFeed(): FeedModel?
    suspend fun saveNewsFeed(newsFeed: FeedModel)
}