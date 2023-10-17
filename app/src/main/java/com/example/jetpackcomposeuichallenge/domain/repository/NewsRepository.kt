package com.example.jetpackcomposeuichallenge.domain.repository

import androidx.paging.PagingData
import com.example.jetpackcomposeuichallenge.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(sources: List<String>) : Flow<PagingData<Article>>
}