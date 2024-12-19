package com.paulajustino.worldinfocusapp.data.local.newsFeed

import com.paulajustino.worldinfocusapp.domain.model.newsFeed.FeedModel
import javax.inject.Inject

class NewsLocalDataSourceImpl @Inject constructor(): NewsLocalDataSource {
    override suspend fun getCachedNewsFeed(): FeedModel? {
        TODO()
    }

    override suspend fun saveNewsFeed(newsFeed: FeedModel) {
        TODO()
    }
}