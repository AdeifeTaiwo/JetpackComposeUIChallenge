package com.example.jetpackcomposeuichallenge.data.local

object ChipData {

    private val allNewsSegment = listOf<String>("Trending", "Latest", "Politics", "Health", "Sports")
    fun getAllNewsChipItem() : List<String> = allNewsSegment

}