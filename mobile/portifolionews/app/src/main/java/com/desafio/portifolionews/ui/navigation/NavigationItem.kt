package com.desafio.portifolionews.ui.navigation

sealed class NavigationItem (val route: String) {
    object Feed: NavigationItem(Screen.FEED.name)
    object Menu: NavigationItem(Screen.MENU.name)
    object Economy: NavigationItem(Screen.ECONOMY.name)
    object WebView: NavigationItem(Screen.WEB_VIEW.name)
}
