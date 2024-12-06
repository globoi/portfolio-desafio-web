package com.desafio.portifolionews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.desafio.feed.presentation.ui.FeedViewModel
import com.desafio.feed.presentation.ui.FeedScreen
import com.desafio.portifolionews.ui.theme.PortifolioNewsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val feedViewModel : FeedViewModel by viewModels<FeedViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PortifolioNewsTheme {
                FeedScreen(feedViewModel)
            }
        }
    }
}
