package com.paulajustino.worldinfocusapp.data.repository.menu

import com.paulajustino.worldinfocusapp.data.local.menu.MenuLocalDataSource
import com.paulajustino.worldinfocusapp.domain.model.menu.MenuItemModel
import javax.inject.Inject

class MenuRepositoryImpl @Inject constructor(
    private val menuLocalDataSource: MenuLocalDataSource
) : MenuRepository {
    override fun getMenuItems(): List<MenuItemModel> {
        return menuLocalDataSource.getMenuItems()
    }
}