package com.paulajustino.worldinfocusapp.data.local

import com.paulajustino.worldinfocusapp.domain.model.FeedModel
import javax.inject.Inject

class NewsLocalDataSourceImpl @Inject constructor(): NewsLocalDataSource {
    override suspend fun getCachedNewsFeed(): FeedModel? {
        TODO()
    }

    override suspend fun saveNewsFeed(newsFeed: FeedModel) {
        TODO()
    }
}