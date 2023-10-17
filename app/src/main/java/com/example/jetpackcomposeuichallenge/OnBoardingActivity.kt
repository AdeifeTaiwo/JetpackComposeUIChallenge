package com.example.jetpackcomposeuichallenge

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.example.compose.JetpackComposeUIChallengeTheme
import com.example.jetpackcomposeuichallenge.domain.usecases.app_entry.AppEntryUseCases
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingActivity : ComponentActivity() {

    @Inject lateinit var appEntryUseCases: AppEntryUseCases

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

      WindowCompat.setDecorFitsSystemWindows(window, false)

        lifecycleScope.launch {
            appEntryUseCases.readAppEntry().collect{
                Log.d("Test", it.toString())
            }
        }

        setContent {
            JetpackComposeUIChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    NewsOnboardingApp()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeUIChallengeTheme {
        Greeting("Android")
    }
}