package com.paulajustino.worldinfocusapp.ui.screens

import android.webkit.WebSettings
import android.webkit.WebView
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun GenericWebViewScreen(url: String, onBackPressed: () -> Unit) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.apply {
                    settings.javaScriptEnabled = true
                    settings.domStorageEnabled = true
                    cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK // Uso de cache para acelerar carregamento
                }
                loadUrl(url)
            }
        },
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
    )

    BackHandler {
        onBackPressed()
    }
}