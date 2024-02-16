package com.example.jetpackcomposeuichallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.jetpackcomposeuichallenge.ui.theme.JetpackComposeUIChallengeTheme
import com.example.jetpackcomposeuichallenge.ui.theme.faintRed
import com.example.jetpackcomposeuichallenge.data.local.BottomMenuProvider
import com.example.jetpackcomposeuichallenge.presentation.home.NewsHomeScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            JetpackComposeUIChallengeTheme {

                val showHomeScreen = remember { mutableStateOf(false) }
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LaunchedEffect(key1 = Unit, block = {
                        delay(timeMillis = 1000)
                        showHomeScreen.value = true
                    })

                    if (!showHomeScreen.value) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            CircularProgressIndicator(color = faintRed)
                        }
                    } else {
                        NewsApp()
                    }
                }

            }
        }
    }
}


@Composable
fun EmptyComingSoon(modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {

        Text(text = "Coming Soon")
        val items = BottomMenuProvider.getAllBottomMenuContent()
    }
}

@Preview(showBackground = true)
@Composable
fun NewsAppPreview() {
    JetpackComposeUIChallengeTheme {
        NewsHomeScreen(name = "Taiwo",
            onNotificationIconClicked = {},
            onClickSeeAllFeaturedNews = {}) {}
    }
}