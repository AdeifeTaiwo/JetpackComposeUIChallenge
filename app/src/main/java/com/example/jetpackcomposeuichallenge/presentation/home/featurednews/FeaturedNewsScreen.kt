package com.example.jetpackcomposeuichallenge.presentation.home.featurednews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeuichallenge.presentation.components.BackButtonWithMenuIcon
import com.example.jetpackcomposeuichallenge.data.local.LocalNewsDataProvider
import com.example.jetpackcomposeuichallenge.data.local.News
import com.example.jetpackcomposeuichallenge.presentation.list_items.FeaturedRowItem


@Composable
fun FeaturedNews(modifier: Modifier) {

    Column(
        modifier = Modifier
            .padding(vertical = 16.dp, horizontal = 0.dp)
            .fillMaxSize()
    )
    {
        val newsColumnLazyListState = rememberLazyListState()
        val allNews: List<News> = LocalNewsDataProvider.getAllNews()



        LazyColumn(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(), state = newsColumnLazyListState
        ) {
            item {
               BackButtonWithMenuIcon(headerText = "Featured News", menuIcon = Icons.Default.Menu)

                Spacer(modifier = Modifier.height(10.dp))
            }


            items(items = allNews, key = { it.id }) { news ->
                FeaturedRowItem(
                    news = news,
                    isSelected = true,
                    state = newsColumnLazyListState
                ) {}
            }


        }
    }


}