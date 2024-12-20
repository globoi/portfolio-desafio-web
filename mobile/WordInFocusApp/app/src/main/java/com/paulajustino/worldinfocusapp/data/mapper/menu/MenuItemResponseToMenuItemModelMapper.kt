package com.paulajustino.worldinfocusapp.data.mapper.menu

import com.paulajustino.worldinfocusapp.data.local.menu.MenuItemResponse
import com.paulajustino.worldinfocusapp.domain.model.menu.MenuItemModel

interface MenuItemResponseToMenuItemModelMapper {
    fun mapToMenuItemModel(from: MenuItemResponse): MenuItemModel
}