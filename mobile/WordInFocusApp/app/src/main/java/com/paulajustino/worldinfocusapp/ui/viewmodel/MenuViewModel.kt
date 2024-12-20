package com.paulajustino.worldinfocusapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.paulajustino.worldinfocusapp.data.repository.menu.MenuRepository
import com.paulajustino.worldinfocusapp.domain.model.menu.MenuItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * ViewModel responsável por gerenciar o estado dos menus.
 */
@HiltViewModel
class MenuViewModel @Inject constructor(
    private val menuRepository: MenuRepository
) : ViewModel() {

    // Estado interno que mantém a lista de itens do menu
    private val _menuItems = MutableStateFlow<List<MenuItemModel>>(emptyList())
    val menuItems: StateFlow<List<MenuItemModel>> = _menuItems

    init {
        loadMenuItems()
    }

    private fun loadMenuItems() {
        try {
            // Atualiza o estado com os itens do menu recuperados
            _menuItems.value = menuRepository.getMenuItems()
        } catch (e: Exception) {
            _menuItems.value = emptyList()
            Log.e("MenuViewModel", "Erro ao carregar os itens do menu: ${e.message}")
        }
    }
}