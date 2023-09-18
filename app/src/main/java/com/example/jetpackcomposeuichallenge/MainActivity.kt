package com.example.jetpackcomposeuichallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.JetpackComposeUIChallengeTheme
import com.example.jetpackcomposeuichallenge.components.AppSearchBar
import com.example.jetpackcomposeuichallenge.components.FeaturedRow
import com.example.jetpackcomposeuichallenge.components.LogoWithNotification
import com.example.jetpackcomposeuichallenge.data.LocalNewsDataProvider
import com.example.jetpackcomposeuichallenge.data.News
import com.example.jetpackcomposeuichallenge.items.FeaturedRowItem
import com.example.jetpackcomposeuichallenge.items.NewsListItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeUIChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NewsHomeScreen(name = "Taiwo")
                }
            }
        }
    }
}


@Composable
fun NewsHomeScreen(modifier: Modifier = Modifier, name: String) {

    val newsLazyListState = rememberLazyListState()
    val newsColumnLazyListState = rememberLazyListState()
    val allNews: List<News> = LocalNewsDataProvider.getAllNews()

    var expanded by remember { mutableStateOf(false) }

    LazyColumn(modifier = modifier) {
        item {


            LogoWithNotification()
            Spacer(modifier = Modifier.height(0.dp))
            AppSearchBar()
            Spacer(modifier = Modifier.height(16.dp))

            FeaturedRow() {

            }
            Spacer(modifier = Modifier.height(16.dp))

            LazyRow(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(), state = newsLazyListState
            ) {

                items(items = allNews, key = { it.id }) { news ->
                    FeaturedRowItem(
                        news = news,
                        isSelected = true,
                        state = newsLazyListState
                    ) {}
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            FeaturedRow(item = "News") {
                expanded = !expanded
            }

            Spacer(modifier = Modifier.height(2.dp))

            AnimatedVisibility(
                visible = !expanded,
                enter = fadeIn(initialAlpha = 0.5f),
                exit = fadeOut(targetAlpha = 1.0f)
            ) {

                NewsListItem(
                    news = allNews[0],
                    isSelected = true,
                    state = newsLazyListState
                ) {

                }
            }
        }


        items(items = allNews, key = { it.id }) { news ->
            AnimatedVisibility(visible = expanded) {

                NewsListItem(
                    news = news,
                    isSelected = true,
                    state = newsLazyListState
                ) {}
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
        NewsHomeScreen(name = "Taiwo")
    }
}