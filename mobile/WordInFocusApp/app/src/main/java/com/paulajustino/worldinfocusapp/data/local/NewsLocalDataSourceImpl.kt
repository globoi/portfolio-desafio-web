package com.paulajustino.worldinfocusapp.data.local

import com.paulajustino.worldinfocusapp.domain.model.FeedModel

class NewsLocalDataSourceImpl : NewsLocalDataSource {
    override suspend fun getCachedNewsFeed(): FeedModel? {
        TODO()
    }

    override suspend fun saveNewsFeed(newsFeed: FeedModel) {
        TODO()
    }
}