package com.paulajustino.worldinfocusapp.data.mapper.menu

import com.paulajustino.worldinfocusapp.data.local.menu.MenuItemResponse
import com.paulajustino.worldinfocusapp.domain.model.menu.MenuItemModel
import javax.inject.Inject

class MenuItemResponseToMenuItemModelMapperImpl @Inject constructor() : MenuItemResponseToMenuItemModelMapper {
    override fun mapToMenuItemModel(from: MenuItemResponse): MenuItemModel {
        return MenuItemModel(
            title = from.title,
            url = from.url
        )
    }
}