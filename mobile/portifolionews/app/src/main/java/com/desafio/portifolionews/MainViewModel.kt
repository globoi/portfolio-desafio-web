package com.desafio.portifolionews

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.desafio.feed.data.repository.FeedRepository
import com.desafio.feed.data.repository.FeedRepositoryImpl
import com.desafio.feed.domain.model.Feed
import com.desafio.feed.domain.model.New
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val feedRepository: FeedRepository
) : ViewModel() {

    private val feedLiveData = MutableLiveData<Feed>()
    val feedLV get() = feedLiveData

    init {
        viewModelScope.launch {
            val news = feedRepository.getFeed()
            feedLiveData.postValue(news)
        }
    }
}
