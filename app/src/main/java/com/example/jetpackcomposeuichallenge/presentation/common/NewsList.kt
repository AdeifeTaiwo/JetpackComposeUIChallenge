package com.example.jetpackcomposeuichallenge.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.jetpackcomposeuichallenge.domain.model.Article
import com.example.jetpackcomposeuichallenge.presentation.list_items.NewsListItem

@Composable
fun NewsList(
    modifier: Modifier = Modifier,
    news: LazyPagingItems<Article>,
    onClick: (Article) -> Unit,
    newsLazyListState: LazyListState,
    isExpanded: Boolean
) {
    val handlePagingResult = handlePagingResult(article = news)
    if(handlePagingResult){
        LazyColumn( modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(all = 4.dp)
        ){

            val itemCount = if(!isExpanded) 1 else news.itemCount
            items(count = itemCount){
                news[it]?.let{
                    NewsListItem(news = it, isSelected = true, state = newsLazyListState ) {
                    }
                }
            }
        }
    }
}

@Composable
fun handlePagingResult(article:LazyPagingItems<Article>): Boolean{

    val loadState = article.loadState
    val error = when {
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }

    return when  {
        loadState.refresh is LoadState.Loading -> {
            ShimmerEffect()
            false
        }

        error !=null ->{
            EmptyScreen()
            false
        }

        else -> true
    }

}

@Composable
private fun ShimmerEffect(){
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        repeat(10){
            NewsCardShimmerEffect(
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }

    }
}