package com.paulajustino.worldinfocusapp.data.repository.menu

import com.paulajustino.worldinfocusapp.domain.model.menu.MenuItemModel

interface MenuRepository {
    fun getMenuItems(): List<MenuItemModel>
}