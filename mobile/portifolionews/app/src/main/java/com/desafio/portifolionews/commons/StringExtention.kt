package com.desafio.portifolionews.commons

import com.desafio.portifolionews.ui.menu.MenuContent
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun String.parseJsonToModel(): MenuContent {
    val gson = Gson()
    return gson.fromJson(this, object : TypeToken<MenuContent>() {}.type)
}
