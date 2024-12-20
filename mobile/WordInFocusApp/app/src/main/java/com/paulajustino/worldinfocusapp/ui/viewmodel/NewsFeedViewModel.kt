package com.paulajustino.worldinfocusapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulajustino.worldinfocusapp.domain.model.newsFeed.NewsFeedState
import com.paulajustino.worldinfocusapp.domain.usecase.newsFeed.GetInitialNewsFeedUseCase
import com.paulajustino.worldinfocusapp.ui.model.NewsItemUiModel
import com.paulajustino.worldinfocusapp.utils.NewsType
import com.paulajustino.worldinfocusapp.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel responsável por gerenciar o estado da tela de feed de notícias.
 */
@HiltViewModel
class NewsFeedViewModel @Inject constructor(
    private val getInitialNewsFeedUseCase: GetInitialNewsFeedUseCase
) : ViewModel() {
    // Estado interno que representa o estado atual do feed de notícias
    private val _newsFeedState = MutableStateFlow<NewsFeedState>(NewsFeedState.Loading)
    val newsFeedState: StateFlow<NewsFeedState> get() = _newsFeedState

    // Map para armazenar as notícias de cada tipo de feed
    private val _newsByType = mutableMapOf<String, List<NewsItemUiModel>>()
    val newsByType: Map<String, List<NewsItemUiModel>> get() = _newsByType

    // Controla o estado de refresh de cada feed por tipo
    private val isRefreshingMap = mutableMapOf<String, Boolean>()

    init {
        // Carrega as notícias iniciais para os tipos de feed específicos
        viewModelScope.launch {
            loadInitialNewsFeed(NewsType.RECENTS.type)
            loadInitialNewsFeed(NewsType.AGRO.type)
        }
    }

    private suspend fun loadInitialNewsFeed(newsType: String) {
        _newsFeedState.value = NewsFeedState.Loading
        try {
            when (val newsItemUiModels = getInitialNewsFeedUseCase.getInitialNewsFeed(newsType)) {
                is Result.Success -> {
                    _newsByType[newsType] = newsItemUiModels.data
                    // Atualiza o estado de sucesso com as notícias carregadas
                    _newsFeedState.value = NewsFeedState.Success(news = newsItemUiModels.data)
                }

                is Result.Error -> {
                    // Caso ocorra um erro, define o estado de erro com mais informações
                    // Caso tenha erro, você pode tratar ou registrar
                    _newsFeedState.value =
                        NewsFeedState.Error("Erro ao carregar as notícias do feed.")
                    Log.e(
                        "NewsFeedViewModel",
                        "Erro ao carregar as notícias para $newsType: ${newsItemUiModels.error.message}"
                    )
                }
            }
        } catch (e: Exception) {
            _newsFeedState.value = NewsFeedState.Error("Erro ao carregar o feed: ${e.message}")
        }
    }

    fun refreshNews(newsType: String) {
        // Marca o tipo de feed como "em refresh"
        isRefreshingMap[newsType] = true
        viewModelScope.launch {
            loadInitialNewsFeed(newsType)
            // Após o refresh, marca como não mais em refresh
            isRefreshingMap[newsType] = false
        }
    }
}

/*
@HiltViewModel
class PagedNewsFeedViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {

    private val _newsFlows = mutableMapOf<String, MutableStateFlow<PagingData<NewsItemModel>>>(
        NewsType.RECENTS.type to MutableStateFlow(PagingData.empty()),
        NewsType.AGRO.type to MutableStateFlow(PagingData.empty())
    )
    val newsFlows: Map<String, StateFlow<PagingData<NewsItemModel>>> get() = _newsFlows

    // Manter o estado de offerId e nextPage para cada feed
    private val nextPageMap = mutableMapOf<String, Int>()
    private val offerIdMap = mutableMapOf<String, String?>()

    init {
        viewModelScope.launch {
            loadInitialNewsFeed(NewsType.RECENTS.type)
            loadInitialNewsFeed(NewsType.AGRO.type)
        }
    }

    private suspend fun loadInitialNewsFeed(newsType: String) {
        when (val response = repository.getInitialNewsFeed(newsType)) {
            is Result.Success -> {
                // Armazena a próxima página e a oferta para esse tipo de notícia
                nextPageMap[newsType] = response.data.nextPage
                offerIdMap[newsType] = response.data.offer

                // Atualiza o fluxo com os dados da primeira página
                _newsFlows[newsType]?.value = PagingData.from(response.data.news)

                // Agora que a primeira chamada foi concluída, use PagingSource para as chamadas subsequentes
                //loadPagedNewsFeed(newsType)
            }

            is Result.Error -> {
                // Lidar com erro (ex: mostrar mensagem de erro)
            }
        }
    }

    private suspend fun loadPagedNewsFeed(newsType: String) {
        // Pega a próxima página usando os dados armazenados
        val pagingDataFlow = repository.getPagedNewsFeed(
            newsType,
            nextPageMap[newsType]?.plus(1)
                ?: 2, // Se a página não estiver armazenada, começa pela página 1
            offerIdMap[newsType]
        )

        pagingDataFlow
            .distinctUntilChanged()
            .cachedIn(viewModelScope)
            .collect { pagingData ->
                // Atualiza o fluxo com os dados paginados
                _newsFlows[newsType]?.value = pagingData

                // Atualiza o próximo estado (nextPage) para a próxima página
                nextPageMap[newsType] =
                    (nextPageMap[newsType] ?: 1) + 1 // Incrementa o nextPage
            }

    }
}*/
