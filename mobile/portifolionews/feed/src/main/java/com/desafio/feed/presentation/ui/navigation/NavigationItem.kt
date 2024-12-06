package com.desafio.feed.presentation.ui.navigation

sealed class NavigationItem (val route: String) {
    object Feed: NavigationItem(Screen.FEED.name)
    object WebView: NavigationItem(Screen.WEB_VIEW.name)
}
