package com.desafio.feed.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.desafio.feed.domain.usecase.FeedUseCase
import com.desafio.feed.presentation.ui.dto.FeedDTO
import com.desafio.feed.presentation.ui.dto.NewsDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val feedUseCase: FeedUseCase
) : ViewModel() {

    val feedState = MutableStateFlow<FeedState>(FeedState.START)

    private val _isRefreshing = MutableStateFlow(false)

    private val feedContent: MutableLiveData<FeedDTO> by lazy {
        MutableLiveData<FeedDTO>()
    }

    fun onPullToRefreshTrigger() {
        _isRefreshing.update { true }
        feedState.value = FeedState.REFRESH(_isRefreshing.value)
    }

    fun loadFeed(content: String) = viewModelScope.launch {
        feedState.value = FeedState.LOADING

        try {

            val feed = withContext(Dispatchers.IO) {
                feedUseCase.fetchFeed(content)
            }

            _isRefreshing.update { false }

            feedState.value = FeedState.SUCCESS(feed, _isRefreshing.value)
            feedContent.value = feed

        } catch (e: Exception) {
            feedState.value = FeedState.FAILURE(e.message.toString())
        }
    }

    fun loadNextPage(): Flow<PagingData<NewsDto>> {
        _isRefreshing.update { false }

        return feedUseCase.fetchNextPage(
            product = feedContent.value?.tenant ?: "",
            id = feedContent.value?.oferta ?: ""
        )
    }
}
