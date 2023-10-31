package com.example.jetpackcomposeuichallenge.presentation.home

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.compose.JetpackComposeUIChallengeTheme
import com.example.jetpackcomposeuichallenge.presentation.components.AppSearchBar
import com.example.jetpackcomposeuichallenge.presentation.components.FeaturedRow
import com.example.jetpackcomposeuichallenge.presentation.components.LogoWithNotification
import com.example.jetpackcomposeuichallenge.data.local.ChipData
import com.example.jetpackcomposeuichallenge.data.local.LocalNewsDataProvider
import com.example.jetpackcomposeuichallenge.data.local.News
import com.example.jetpackcomposeuichallenge.domain.model.Article
import com.example.jetpackcomposeuichallenge.presentation.common.HomeScreen
import com.example.jetpackcomposeuichallenge.presentation.list_items.ChipItem
import com.example.jetpackcomposeuichallenge.presentation.list_items.FeaturedRowItem

@Composable
fun NewsHomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    name: String,
    onClickSeeAllFeaturedNews: (String) -> Unit,
    onNotificationIconClicked: () -> Unit
) {

    val newsLazyListState = rememberLazyListState()
    val newsColumnLazyListState = rememberLazyListState()
    val allNews: List<News> = LocalNewsDataProvider.getAllNews()
    val news: List<Article>
    val article = viewModel.news.collectAsLazyPagingItems()


    LaunchedEffect(key1 = true, block = {
        viewModel.news.collect {
            Log.d("TAP", it.toString())
        }
    })

    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxHeight()
            .windowInsetsPadding(WindowInsets.systemBars)
    ) {

        LogoWithNotification() {
            onNotificationIconClicked()
        }
        Spacer(modifier = Modifier.height(0.dp))
        AppSearchBar()
        Spacer(modifier = Modifier.height(16.dp))
        FeaturedRow {
            onClickSeeAllFeaturedNews(it)
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
                ) {

                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        FeaturedRow(item = "News") {
            expanded = !expanded
        }

        Spacer(modifier = Modifier.height(8.dp))
        ChipItem(chips = ChipData.getAllNewsChipItem())
        Spacer(modifier = Modifier.height(16.dp))


        AnimatedVisibility(
            visible = !expanded,
            enter = fadeIn(initialAlpha = 0.5f),
            exit = fadeOut(targetAlpha = 1.0f)
        ) {
            HomeScreen(articles = article,
                navigate = {},
                newsColumnLazyListState,
                isExpanded = expanded
            )

        }
        val heightWhenExpanded = if (expanded) 200.dp * (allNews.size - 1) else 0.dp
        Column(modifier = Modifier.height(heightWhenExpanded)) {

            HomeScreen(
                articles = article,
                navigate = {},
                newsColumnLazyListState,
                isExpanded = expanded
            )

        }
    }


}


@Preview(showBackground = true)
@Composable

fun PreviewHomeScreen(){
    JetpackComposeUIChallengeTheme {
        NewsHomeScreen(name = "Taiwo", onClickSeeAllFeaturedNews = {}) {

        }
    }
}
