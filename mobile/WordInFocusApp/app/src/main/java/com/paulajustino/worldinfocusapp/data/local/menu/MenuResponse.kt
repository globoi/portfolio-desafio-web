package com.paulajustino.worldinfocusapp.data.local.menu

import com.squareup.moshi.Json

data class MenuResponse(
    @Json(name = "menuItems") val menuItems: List<MenuItemResponse>
)

data class MenuItemResponse(
    @Json(name = "title") val title: String,
    @Json(name = "url") val url: String
)
