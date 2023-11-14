package com.example.jetpackcomposeuichallenge.domain.usecases.get_news

import androidx.paging.PagingData
import com.example.jetpackcomposeuichallenge.domain.model.Article
import com.example.jetpackcomposeuichallenge.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(searchQuery: String, sources: List<String>) : Flow<PagingData<Article>> {
        return newsRepository.searchNew(searchQuery, sources)
    }
}