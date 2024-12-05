package com.desafio.portifolionews

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.desafio.feed.data.repository.FeedRepository
import com.desafio.feed.domain.model.FeedNews
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val feedRepository: FeedRepository
) : ViewModel() {

    private val feedNewsLiveData = MutableLiveData<FeedNews>()
    val feedLV get() = feedNewsLiveData

    init {
        viewModelScope.launch {
            val news = feedRepository.getFeed()
            feedNewsLiveData.postValue(news)
        }
    }
}
