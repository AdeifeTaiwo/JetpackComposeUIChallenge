package com.example.jetpackcomposeuichallenge.data

import com.example.jetpackcomposeuichallenge.R


object NewsTopicsProvider {

    private val allTopics = listOf<Topics>(
        Topics(R.drawable.joe_biden, "policics"),
        Topics(R.drawable.bg_7, "Sports"),
        Topics(R.drawable.bg_6, "Science"),
        Topics(R.drawable.joe_biden, "Arts"),
        Topics(R.drawable.bg_3, "Fashion"),
        Topics(R.drawable.bg_5, "Technology"),
        Topics(R.drawable.splash, "Education"),
        Topics(R.drawable.three_lines, "Health")

    )

    val getAllTopics: List<Topics> = allTopics
}

data class Topics(
    val image: Int,
    val topic: String
)