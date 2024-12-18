package com.paulajustino.worldinfocusapp.data.mapper

import com.paulajustino.worldinfocusapp.domain.model.FeedModel
import com.paulajustino.worldinfocusapp.data.remote.api.FeedResponse

interface FeedResponseToFeedModelMapper {
    fun mapToFeedModel(from: FeedResponse): FeedModel
}