package com.paulajustino.worldinfocusapp.data.mapper.menu

import com.paulajustino.worldinfocusapp.data.local.menu.MenuResponse
import com.paulajustino.worldinfocusapp.domain.model.menu.MenuModel

interface MenuResponseToMenuModelMapper {
    fun mapToMenuModel(from: MenuResponse): MenuModel
}