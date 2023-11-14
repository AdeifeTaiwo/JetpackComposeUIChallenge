package com.example.jetpackcomposeuichallenge.presentation.search

import androidx.paging.PagingData
import com.example.jetpackcomposeuichallenge.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(

    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
    )