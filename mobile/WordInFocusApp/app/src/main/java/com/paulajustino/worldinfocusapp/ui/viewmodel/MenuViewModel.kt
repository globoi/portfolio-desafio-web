package com.paulajustino.worldinfocusapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.paulajustino.worldinfocusapp.data.repository.menu.MenuRepository
import com.paulajustino.worldinfocusapp.domain.model.menu.MenuItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val menuRepository: MenuRepository
) : ViewModel() {

    private val _menuItems = MutableStateFlow<List<MenuItemModel>>(emptyList())
    val menuItems: StateFlow<List<MenuItemModel>> = _menuItems

    init {
        loadMenuItems()
    }

    private fun loadMenuItems() {
        _menuItems.value = menuRepository.getMenuItems()
    }
}