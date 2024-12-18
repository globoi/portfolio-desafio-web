package com.paulajustino.worldinfocusapp.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulajustino.worldinfocusapp.domain.model.FeedState
import com.paulajustino.worldinfocusapp.domain.model.NewsItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel responsável por gerenciar o estado da tela de feed de notícias.
 */
class FeedViewModel : ViewModel() {

    // Estado interno para controlar o feed
    private val _feedState = MutableStateFlow<FeedState>(FeedState.Loading(false))
    val feedState: StateFlow<FeedState> get() = _feedState

    // Estado interno para controlar as notícias carregadas
    private val _news = mutableStateOf<List<NewsItem>>(emptyList())
    val news: State<List<NewsItem>> get() = _news

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
        _feedState.value = FeedState.Loading(isRefreshing)

        viewModelScope.launch {
            try {
                // Se estiver fazendo refresh, reinicia a página
                if (isRefreshing) currentPage = 1

                val feedResponse = fetchFeed(page = currentPage)

                val filteredNews =
                    feedResponse.items.filter { it.type == "basico" || it.type == "materia" }

                // Se for refresh, começa com a lista limpa, senão, adiciona às notícias existentes
                val newNews = if (isRefreshing) filteredNews else _news.value + filteredNews
                _news.value = newNews

                _feedState.value = FeedState.Success(news = newNews)

                // Incrementa a página para próxima requisição (caso não seja refresh)
                if (!isRefreshing) currentPage++

            } catch (e: Exception) {
                // Atualiza o estado para Error com a mensagem de erro
                _feedState.value = FeedState.Error("Erro ao carregar o feed: ${e.message}")
            }
        }
    }

    private fun fetchFeed(page: Int): FeedResponse {
        // Simulação de uma chamada para API
        return FeedResponse(
            items = List(10) { index ->
                NewsItem(
                    id = index.toString(),
                    title = "Notícia $index",
                    description = "Descrição da notícia $index",
                    type = if (index % 2 == 0) "basico" else "materia",
                    chapeu = "Chapeu $index",
                    metadata = "Metadata $index",
                    url = "url da notícia $index"
                )
            }
        )
    }
}

// Modelo de resposta da API
data class FeedResponse(
    val items: List<NewsItem>
)