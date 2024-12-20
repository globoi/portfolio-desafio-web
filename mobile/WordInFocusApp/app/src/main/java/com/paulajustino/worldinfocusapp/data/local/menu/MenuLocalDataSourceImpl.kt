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

    val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    override fun getMenuItems(): List<MenuItemModel> {
        return try {
            // use() garante o fechamento do InputStream após a leitura
            context.assets.open(MENU_FILE_NAME).bufferedReader().use { reader ->
                val jsonString = reader.readText()

                // Parse do JSON para o objeto MenuResponse
                val jsonAdapter: JsonAdapter<MenuResponse> = moshi.adapter(MenuResponse::class.java)
                val menuResponse = jsonAdapter.fromJson(jsonString)

                // Retorna a lista de MenuItems ou uma lista vazia se o objeto for nulo
                menuResponse?.menuItems?.map { menuItemResponse ->
                    MenuItemModel(
                        title = menuItemResponse.title,
                        url = menuItemResponse.url
                    )
                } ?: emptyList()
            }
        } catch (e: FileNotFoundException) {
            Log.e("FileError", "Arquivo Menu.json não encontrado: ${e.message}")
            emptyList()
        } catch (e: Exception) {
            Log.e("FileError", "Erro ao carregar arquivo Menu.json: ${e.message}")
            emptyList()
        }
    }

    companion object {
        private const val MENU_FILE_NAME = "Menu.json"
    }
}