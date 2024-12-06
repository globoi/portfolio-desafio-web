package com.desafio.portifolionews.commons

import android.content.Context

fun Context.readJsonFromAssets(fileName: String): String {
    return assets.open(fileName).bufferedReader().use { it.readText() }
}
