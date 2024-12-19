package com.paulajustino.worldinfocusapp.domain.model.menu

data class MenuModel(
    val menuItems: List<MenuItemModel>
)

data class MenuItemModel(
    val title: String,
    val url: String
)