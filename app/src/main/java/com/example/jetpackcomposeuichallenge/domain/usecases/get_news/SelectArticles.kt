package com.example.jetpackcomposeuichallenge.domain.usecases.get_news

import com.example.jetpackcomposeuichallenge.data.local.database.NewsDao
import com.example.jetpackcomposeuichallenge.domain.model.Article
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(): Flow<List<Article>> {
        return newsDao.getArticles()
    }
}