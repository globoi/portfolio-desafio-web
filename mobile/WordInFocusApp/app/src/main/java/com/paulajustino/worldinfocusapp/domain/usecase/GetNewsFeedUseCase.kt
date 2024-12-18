package com.paulajustino.worldinfocusapp.domain.usecase

import com.paulajustino.worldinfocusapp.domain.model.FeedModel
import com.paulajustino.worldinfocusapp.utils.NetworkError
import com.paulajustino.worldinfocusapp.utils.Result

class GetNewsFeedUseCase () {
    suspend fun invoke(): Result<FeedModel, NetworkError> {
        TODO()
    }
}