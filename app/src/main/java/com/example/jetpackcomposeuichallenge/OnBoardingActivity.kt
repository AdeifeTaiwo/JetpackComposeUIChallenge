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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.jetpackcomposeuichallenge.ui.theme.JetpackComposeUIChallengeTheme
import com.example.jetpackcomposeuichallenge.domain.usecases.app_entry.AppEntryUseCases
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingActivity : ComponentActivity() {

    @Inject
    lateinit var appEntryUseCases: AppEntryUseCases


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            JetpackComposeUIChallengeTheme {


                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    var shouldShowOnBoarding by remember {
                        mutableStateOf(false)
                    }

                    LaunchedEffect(key1 = true, block = {
                        appEntryUseCases.readAppEntry().collect {
                            Log.d("Testtt", it.toString())
                            shouldShowOnBoarding = it
                        }
                    })

                    if (true) {
                        NewsOnboardingApp()
                    } else
                        NewsApp()
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