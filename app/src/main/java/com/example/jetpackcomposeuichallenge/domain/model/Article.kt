package com.example.jetpackcomposeuichallenge.domain.model

import kotlin.random.Random

data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String,
){
    fun setGenr() : String{
        val randomGenreList = listOf("Politics", "Sports", "Food", "Health")
        val randomNumber = (0..3).random()
       return randomGenreList[randomNumber]
    }

}