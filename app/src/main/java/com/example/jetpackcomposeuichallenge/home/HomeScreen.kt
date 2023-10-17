package com.example.jetpackcomposeuichallenge.home

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeuichallenge.components.AppSearchBar
import com.example.jetpackcomposeuichallenge.components.FeaturedRow
import com.example.jetpackcomposeuichallenge.components.LogoWithNotification
import com.example.jetpackcomposeuichallenge.data.local.ChipData
import com.example.jetpackcomposeuichallenge.data.local.LocalNewsDataProvider
import com.example.jetpackcomposeuichallenge.data.local.News
import com.example.jetpackcomposeuichallenge.items.ChipItem
import com.example.jetpackcomposeuichallenge.items.FeaturedRowItem
import com.example.jetpackcomposeuichallenge.items.NewsListItem

@Composable
fun NewsHomeScreen(
    modifier: Modifier = Modifier,
    name: String,
    onClickSeeAllFeaturedNews: (String) -> Unit,
    onNotificationIconClicked: () -> Unit
) {

    val newsLazyListState = rememberLazyListState()
    val newsColumnLazyListState = rememberLazyListState()
    val allNews: List<News> = LocalNewsDataProvider.getAllNews()

    var expanded by remember { mutableStateOf(false) }


    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxHeight()
            .windowInsetsPadding(WindowInsets.systemBars)
    ) {

        LogoWithNotification(){
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
                ) {}
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

            NewsListItem(
                news = allNews[0],
                isSelected = true,
                state = newsColumnLazyListState
            ) {

            }
        }
        val heightWhenExpanded = if (expanded) 200.dp * (allNews.size - 1) else 0.dp
        Column(modifier = Modifier.height(heightWhenExpanded)) {

            LazyColumn {
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


    }

}
