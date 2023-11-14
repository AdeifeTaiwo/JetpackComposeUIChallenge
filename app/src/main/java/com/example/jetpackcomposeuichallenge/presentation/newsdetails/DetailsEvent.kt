package com.example.jetpackcomposeuichallenge.presentation.newsdetails

import com.example.jetpackcomposeuichallenge.domain.model.Article

sealed class DetailsEvent {

    data class UpdateAndDeleteArticle(
        val article: Article
    ): DetailsEvent()
    object RemoveSideEffect: DetailsEvent()

}