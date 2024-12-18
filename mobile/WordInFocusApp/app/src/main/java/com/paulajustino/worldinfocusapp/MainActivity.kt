package com.paulajustino.worldinfocusapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.paulajustino.worldinfocusapp.ui.screens.HomeScreen
import com.paulajustino.worldinfocusapp.ui.theme.WorldInFocusAppTheme
import com.paulajustino.worldinfocusapp.ui.viewmodel.NewsFeedViewModel

class MainActivity : ComponentActivity() {

    private val newsFeedViewModel: NewsFeedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WorldInFocusAppTheme {
                HomeScreen(viewModel = newsFeedViewModel)
            }
        }
    }
}

