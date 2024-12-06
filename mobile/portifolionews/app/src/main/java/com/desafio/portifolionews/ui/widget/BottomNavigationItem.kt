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
                label = "Search",
                route = NavigationItem.Economy.route
            ),
            BottomNavigationItem(
                label = "Profile",
                route = NavigationItem.Menu.route
            ),
        )
    }
}
