package com.example.jetpackcomposeuichallenge.data


import androidx.annotation.DrawableRes

data class News(
    val id: Long,
    val headline: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val news: String,
    @DrawableRes val images: Int,
    var isCurrentAccount: Boolean = false
) {
    val fullName: String = "$firstName $lastName"
}
