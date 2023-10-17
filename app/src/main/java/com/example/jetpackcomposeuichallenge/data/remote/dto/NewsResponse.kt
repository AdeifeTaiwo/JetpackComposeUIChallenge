package com.example.jetpackcomposeuichallenge.data.remote.dto

import com.example.jetpackcomposeuichallenge.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)