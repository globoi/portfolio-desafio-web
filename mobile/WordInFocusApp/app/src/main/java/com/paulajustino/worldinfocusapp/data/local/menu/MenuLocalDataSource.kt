package com.paulajustino.worldinfocusapp.data.local.menu

import com.paulajustino.worldinfocusapp.domain.model.menu.MenuItemModel

interface MenuLocalDataSource {
    fun getMenuItems(): List<MenuItemModel>
}