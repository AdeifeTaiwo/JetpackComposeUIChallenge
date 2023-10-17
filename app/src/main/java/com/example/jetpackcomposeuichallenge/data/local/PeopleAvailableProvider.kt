package com.example.jetpackcomposeuichallenge.data.local

import androidx.annotation.DrawableRes
import com.example.jetpackcomposeuichallenge.R


object PeopleAvailableProvider {

    private val peopleAvailable: List<People> = listOf(
        People(
            id = 1L,
            newsChannel = "BBC",
            newsAvatar = R.drawable.bg_5,
            peopleFollowing = "25.4k follower",
            hasFollowed = true
        ),
        People(
            id = 2L,
            newsChannel = "CNN",
            newsAvatar = R.drawable.bg_1,
            peopleFollowing = "22.4k follower",
            hasFollowed = false
        ),
        People(
            id = 3L,
            newsChannel = "BBC",
            newsAvatar = R.drawable.bg_3,
            peopleFollowing = "2.4k follower",
            hasFollowed = true
        ),
        People(
            id = 4L,
            newsChannel = "BBC",
            newsAvatar = R.drawable.joe_biden,
            peopleFollowing = "25.4k follower",
            hasFollowed = false
        ),
        People(
            id = 5L,
            newsChannel = "BBC",
            newsAvatar = R.drawable.splash,
            peopleFollowing = "25.4k follower",
            hasFollowed = true
        ),
        People(
            id = 6L,
            newsChannel = "BBC",
            newsAvatar = R.drawable.bg_5,
            peopleFollowing = "25.4k follower",
            hasFollowed = false
        ),
        People(
            id = 7L,
            newsChannel = "BBC",
            newsAvatar = R.drawable.bg_5,
            peopleFollowing = "25.4k follower",
            hasFollowed = false
        ),
        People(
            id = 8L,
            newsChannel = "BBC",
            newsAvatar = R.drawable.bg_5,
            peopleFollowing = "25.4k follower",
            hasFollowed = false
        )
    )

    fun getAvailablePeople(): List<People> = peopleAvailable

    data class People(
        val id: Long,
        val newsChannel: String,
        @DrawableRes val newsAvatar: Int,
        val peopleFollowing: String,
        val hasFollowed: Boolean
    )

}