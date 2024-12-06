package com.desafio.feed.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.desafio.feed.presentation.ui.FeedScreen
import com.desafio.feed.presentation.ui.FeedViewModel
import com.desafio.feed.presentation.ui.WebViewScreen
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Feed.route,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Feed.route) {
            val viewModel = hiltViewModel<FeedViewModel>()
            FeedScreen(
                feedViewModel = viewModel,
                onNavigateToNew = { url ->
                    val encodedUrl = URLEncoder.encode(url, StandardCharsets.UTF_8.toString())
                    navController.navigate("${NavigationItem.WebView.route}/$encodedUrl")
            })
        }
        composable(route = "${NavigationItem.WebView.route}/{url}",
            arguments = listOf(navArgument("url") {
                type = NavType.StringType
            }
            )) { backStackEntry ->
            val url = backStackEntry.arguments?.getString("url")
            url?.let {
                WebViewScreen(url = url)
            }
        }
    }
}
