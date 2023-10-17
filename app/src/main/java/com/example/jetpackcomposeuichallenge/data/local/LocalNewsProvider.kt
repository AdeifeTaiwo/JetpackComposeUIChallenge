package com.example.jetpackcomposeuichallenge.data.local
import com.example.jetpackcomposeuichallenge.R

object LocalNewsDataProvider {

    private val allNews = listOf(
        News(
            id = 1L,
            headline = "Experience the Serenity\nin Japan",
            firstName = "Jeff",
            lastName = "Hansen",
            email = "hikingfan@gmail.com",
            news = "hkngfan@outside.com",
            images = R.drawable.joe_biden,
            isCurrentAccount = true
        ),
        News(
            id = 2L,
            headline = "Experience the Serenity\nin Japan",
            firstName = "Jeff",
            lastName = "Hansen",
            email = "hikingfan@gmail.com",
            news = "hkngfan@outside.com",
            images = R.drawable.bg_5,
            isCurrentAccount = true
        ),
        News(
            id = 3L,
            headline = "Experience the Serenity\nin Japan",
            firstName = "Jeff",
            lastName = "Hansen",
            email = "hikingfan@gmail.com",
            news = "hkngfan@outside.com",
            images = R.drawable.bg_4,
            isCurrentAccount = true
        ),

        News(
            id = 4L,
            headline = "Experience the Serenity\nin Japan",
            firstName = "Jeff",
            lastName = "Hansen",
            email = "hikingfan@gmail.com",
            news = "hkngfan@outside.com",
            images = R.drawable.bg_3,
            isCurrentAccount = true
        ),
        News(
            id = 5L,
            headline = "Experience the Serenity\nin Japan",
            firstName = "Jeff",
            lastName = "Hansen",
            email = "hikingfan@gmail.com",
            news = "hkngfan@outside.com",
            images = R.drawable.bg_3,
            isCurrentAccount = true
        )
    )

    fun getAllNews() : List<News> = allNews



}