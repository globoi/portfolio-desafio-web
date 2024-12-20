package com.paulajustino.worldinfocusapp.data.mapper.newsFeed

import com.paulajustino.worldinfocusapp.domain.model.newsFeed.FeedModel
import com.paulajustino.worldinfocusapp.data.remote.newsFeed.NewsFeedResponse

interface FeedResponseToFeedModelMapper {
    fun mapToFeedModel(from: NewsFeedResponse): FeedModel
}