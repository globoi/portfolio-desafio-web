package com.desafio.feed.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.desafio.feed.domain.usecase.FeedUseCase
import com.desafio.feed.presentation.ui.dto.NewsDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val feedUseCase: FeedUseCase
) : ViewModel() {

    val feedState = MutableStateFlow<FeedState>(FeedState.START)

    fun loadFeed() = viewModelScope.launch {
        feedState.value = FeedState.LOADING
        try {
            val feed = withContext(Dispatchers.IO) {
                feedUseCase.fetchFeed()
            }
            feedState.value = FeedState.SUCCESS(feed)
        } catch (e: Exception) {
            feedState.value = FeedState.FAILURE(e.message.toString())
        }
    }

    fun loadNextPage(
        product: String,
        id: String
    ): Flow<PagingData<NewsDto>> {
        return feedUseCase.fetchNextPage(
            product = product,
            id = id
        )
    }
}
