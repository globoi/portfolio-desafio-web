package com.paulajustino.worldinfocusapp.domain.usecase.newsFeed

import com.paulajustino.worldinfocusapp.ui.model.NewsItemUiModel
import com.paulajustino.worldinfocusapp.utils.NetworkError
import com.paulajustino.worldinfocusapp.utils.Result

interface GetInitialNewsFeedUseCase {
    suspend fun getInitialNewsFeed(newsType: String): Result<List<NewsItemUiModel>, NetworkError>
}