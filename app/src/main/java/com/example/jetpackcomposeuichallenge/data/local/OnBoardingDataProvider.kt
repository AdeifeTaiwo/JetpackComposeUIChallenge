package com.example.jetpackcomposeuichallenge.data.local

import com.example.jetpackcomposeuichallenge.R

object OnBoardingDataProvider {

    private val onBoarding = listOf<OnBoarding>(
        OnBoarding(
            image = R.drawable.splash,
            description = "Welcome"
        ),
        OnBoarding(
            image = R.drawable.joe_biden,
            description = "Get Latest News From Around the world"
        ),
        OnBoarding(
            image = R.drawable.bg_3,
            description = "Get Actual News From Around the world"
        ),
        OnBoarding(
            image = R.drawable.bg_6,
            description = "Sports,Politics, Health, anything from around the world"
        )
    )

    fun getOnboardingData() : List<OnBoarding> = onBoarding

    data class OnBoarding(
        val image:Int,
        val description: String
    )
}