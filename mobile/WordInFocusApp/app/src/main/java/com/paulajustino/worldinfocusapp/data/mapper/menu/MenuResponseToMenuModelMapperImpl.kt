package com.paulajustino.worldinfocusapp.data.mapper.menu

import com.paulajustino.worldinfocusapp.data.local.menu.MenuResponse
import com.paulajustino.worldinfocusapp.domain.model.menu.MenuModel
import javax.inject.Inject

class MenuResponseToMenuModelMapperImpl @Inject constructor(
    private val menuItemMapper: MenuItemResponseToMenuItemModelMapper
) : MenuResponseToMenuModelMapper {
    override fun mapToMenuModel(from: MenuResponse): MenuModel {
        val menuItems = from.menuItems.map {
            menuItemMapper.mapToMenuItemModel(it)
        }
        return MenuModel(menuItems = menuItems)
    }
}