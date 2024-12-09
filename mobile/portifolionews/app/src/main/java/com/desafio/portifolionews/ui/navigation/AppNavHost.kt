package com.desafio.portifolionews.ui.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
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
import com.desafio.portifolionews.commons.parseJsonToModel
import com.desafio.portifolionews.commons.readJsonFromAssets
import com.desafio.portifolionews.ui.menu.MenuScreen
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun AppNavHost(
    context: Context,
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
                content = "g1",
                feedViewModel = viewModel,
                onNavigateToNew = { url ->
                    val encodedUrl = URLEncoder.encode(url, StandardCharsets.UTF_8.toString())
                    navController.navigate("${NavigationItem.WebView.route}/$encodedUrl")
                })
        }

        composable(NavigationItem.Economy.route) {
            val viewModel = hiltViewModel<FeedViewModel>()
            FeedScreen(
                content = "/https://g1.globo.com/economia/agronegocios",
                feedViewModel = viewModel,
                onNavigateToNew = { url ->
                    val encodedUrl = URLEncoder.encode(url, StandardCharsets.UTF_8.toString())
                    navController.navigate("${NavigationItem.WebView.route}/$encodedUrl")
                })
        }

        composable(NavigationItem.Menu.route) {

            val jsonString = context.readJsonFromAssets("menu.json")
            val bookList = jsonString.parseJsonToModel()

            MenuScreen(bookList, onNavigateToMenuItem = { url ->
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
