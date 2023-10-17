package com.example.jetpackcomposeuichallenge.data.local

import androidx.annotation.DrawableRes

data class Country(
    @DrawableRes val flag: Int,
    val countryCode: String,
    val countryName: String
)
