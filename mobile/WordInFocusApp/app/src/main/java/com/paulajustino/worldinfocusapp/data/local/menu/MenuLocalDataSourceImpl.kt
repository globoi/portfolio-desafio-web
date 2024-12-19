package com.paulajustino.worldinfocusapp.data.local.menu

import android.content.Context
import android.util.Log
import com.paulajustino.worldinfocusapp.domain.model.menu.MenuItemModel
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.FileNotFoundException
import javax.inject.Inject

class MenuLocalDataSourceImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : MenuLocalDataSource {
    override fun getMenuItems(): List<MenuItemModel> {
        return try {
            // Lê o arquivo JSON da pasta assets
            val inputStream = context.assets.open("Menu.json")
            val jsonString = inputStream.bufferedReader().use { it.readText() }

            // Cria o Moshi e configura o adaptador KotlinJsonAdapterFactory
            val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            val jsonAdapter: JsonAdapter<MenuResponse> = moshi.adapter(MenuResponse::class.java)

            // Faz o parse do JSON para o objeto MenuResponse
            val menuResponse = jsonAdapter.fromJson(jsonString)

            // Retorna a lista de MenuItems, se presente
            menuResponse?.menuItems?.let {
                it.map { menuItemResponse ->
                    MenuItemModel(
                        title = menuItemResponse.title,
                        url = menuItemResponse.url
                    )
                }
            } ?: emptyList()
        } catch (e: FileNotFoundException) {
            Log.e("FileError", "Arquivo Menu.json não encontrado: ${e.message}")
            emptyList()
        } catch (e: Exception) {
            Log.e("FileError", "Erro ao carregar arquivo Menu.json: ${e.message}")
            emptyList()
        }
    }
}