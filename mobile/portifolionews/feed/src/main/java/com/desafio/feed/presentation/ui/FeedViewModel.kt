package com.desafio.feed.presentation.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.desafio.feed.domain.model.Feed
import com.desafio.feed.domain.usecase.FeedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val feedUseCase: FeedUseCase
) : ViewModel() {

    private val _feedLiveData = MutableLiveData<Feed>()
    val feedLiveData get() = _feedLiveData

    val feedState = MutableStateFlow<FeedState>(FeedState.START)

    init {
        loadUser()
    }

    private fun loadUser() = viewModelScope.launch {
        feedState.value = FeedState.LOADING
        try {
            val feed = withContext(Dispatchers.IO) { feedUseCase.fetchFeed() }
            feedState.value = FeedState.SUCCESS(feed)
        } catch (e: Exception) {
            feedState.value = FeedState.FAILURE(e.message.toString())
        }
    }
}
