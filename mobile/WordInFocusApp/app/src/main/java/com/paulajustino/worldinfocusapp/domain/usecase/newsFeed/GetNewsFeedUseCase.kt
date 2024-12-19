package com.paulajustino.worldinfocusapp.domain.usecase.newsFeed

import com.paulajustino.worldinfocusapp.domain.model.newsFeed.FeedModel
import com.paulajustino.worldinfocusapp.utils.NetworkError
import com.paulajustino.worldinfocusapp.utils.Result

class GetNewsFeedUseCase () {
    suspend fun invoke(): Result<FeedModel, NetworkError> {
        TODO()
    }
}