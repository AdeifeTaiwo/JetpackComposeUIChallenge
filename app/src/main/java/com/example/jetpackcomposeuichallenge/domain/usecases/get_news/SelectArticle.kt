package com.example.jetpackcomposeuichallenge.domain.usecases.get_news

import com.example.jetpackcomposeuichallenge.data.local.database.NewsDao
import com.example.jetpackcomposeuichallenge.domain.model.Article

class SelectArticle(
  private val newsDao: NewsDao
) {

    suspend operator fun invoke(url: String) {
     newsDao.getArticle(url)
    }
}