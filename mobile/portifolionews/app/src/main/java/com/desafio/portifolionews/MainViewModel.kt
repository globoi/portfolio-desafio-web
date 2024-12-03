package com.desafio.portifolionews

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.desafio.feed.data.repository.FeedRepositoryImpl
import com.desafio.feed.domain.model.Feed
import com.desafio.feed.domain.model.New
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val feedLiveData = MutableLiveData<Feed>()
    val feedLV get() = feedLiveData

    init {
        val feedRepositoryImpl = FeedRepositoryImpl()

        viewModelScope.launch {
            val news = feedRepositoryImpl.getFeed()
            feedLiveData.postValue(news)
        }
    }
}
