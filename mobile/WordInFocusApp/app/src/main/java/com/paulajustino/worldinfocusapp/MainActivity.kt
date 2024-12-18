package com.paulajustino.worldinfocusapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.paulajustino.worldinfocusapp.ui.MainScreen
import com.paulajustino.worldinfocusapp.ui.theme.WorldInFocusAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WorldInFocusAppTheme {
                MainScreen()
            }
        }
    }
}