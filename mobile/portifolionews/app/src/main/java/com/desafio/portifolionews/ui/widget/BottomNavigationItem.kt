package com.desafio.portifolionews.ui.widget

import com.desafio.portifolionews.ui.navigation.NavigationItem

data class BottomNavigationItem(
    val label: String = "",
    val route: String = ""
) {
    fun bottomNavigationItems(): List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "Home",
                route = NavigationItem.Feed.route
            ),
            BottomNavigationItem(
                label = "Economy",
                route = NavigationItem.Economy.route
            ),
            BottomNavigationItem(
                label = "Menu",
                route = NavigationItem.Menu.route
            ),
        )
    }
}
