package com.paulajustino.worldinfocusapp.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulajustino.worldinfocusapp.data.repository.NewsRepositoryImpl
import com.paulajustino.worldinfocusapp.domain.model.NewsItemModel
import com.paulajustino.worldinfocusapp.domain.model.NewsState
import com.paulajustino.worldinfocusapp.utils.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel responsável por gerenciar o estado da tela de feed de notícias.
 */
class NewsFeedViewModel : ViewModel() {

    private val repository = NewsRepositoryImpl()

    // Estado interno para controlar o feed
    private val _newsState = MutableStateFlow<NewsState>(NewsState.Loading(false))
    val newsState: StateFlow<NewsState> get() = _newsState

    // Estado interno para controlar as notícias carregadas
    private val _news = mutableStateOf<List<NewsItemModel>>(emptyList())
    val news: State<List<NewsItemModel>> get() = _news

    private var currentPage = 1 // será usado posteriormente para a paginação

    init {
        loadFeed(isRefreshing = false)
    }

    /**
     * Carrega o feed de notícias, podendo ser um carregamento inicial ou um refresh.
     *
     * @param isRefreshing Indica se é um refresh, nesse caso, os dados antigos devem ser limpados
     */
    private fun loadFeed(isRefreshing: Boolean) {
        _newsState.value = NewsState.Loading(isRefreshing)

        viewModelScope.launch {
            try {
                // Se for refresh, reinicia a página
                if (isRefreshing) currentPage = 1

                var filteredNewsFeed = emptyList<NewsItemModel>()
                when (val feedModel = repository.getNewsFeed(0)) {
                    is Result.Success -> {
                        filteredNewsFeed =
                            feedModel.value.news.filter { it.type == "basico" || it.type == "materia" }
                    }

                    is Result.Error -> {}
                }

                // Se for refresh, começa com a lista limpa, senão, adiciona às notícias existentes
                val newNews = if (isRefreshing) filteredNewsFeed else _news.value + filteredNewsFeed
                _news.value = newNews

                _newsState.value = NewsState.Success(news = newNews)

                // Incrementa a página para próxima requisição (caso não seja refresh)
                if (!isRefreshing) currentPage++

            } catch (e: Exception) {
                _newsState.value = NewsState.Error("Erro ao carregar o feed: ${e.message}")
            }
        }
    }
}