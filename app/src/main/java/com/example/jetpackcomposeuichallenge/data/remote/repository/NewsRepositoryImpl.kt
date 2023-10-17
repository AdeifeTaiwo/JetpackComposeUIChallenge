package com.example.jetpackcomposeuichallenge.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.jetpackcomposeuichallenge.data.remote.NewsApi
import com.example.jetpackcomposeuichallenge.data.remote.paging.NewsPagingSource
import com.example.jetpackcomposeuichallenge.domain.model.Article
import com.example.jetpackcomposeuichallenge.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsApi: NewsApi
) : NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return  Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }
}