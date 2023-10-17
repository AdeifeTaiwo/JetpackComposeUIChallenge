package com.example.jetpackcomposeuichallenge.data.local

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.FormatListBulleted
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import com.example.jetpackcomposeuichallenge.utility.NewsRoute


object BottomMenuProvider {

    private val allBottomMenuContent: List<BottomMenuContent> = listOf(
        BottomMenuContent(
            "Home",
            Icons.Default.Home,
            NewsRoute.HOME
        ),
        BottomMenuContent(
            "Search",
            Icons.Default.Search,
            NewsRoute.SEARCH
        ),
        BottomMenuContent(
            "Bookmark",
            Icons.Default.BookmarkBorder,
            NewsRoute.BOOKMARK
        ),
        BottomMenuContent(
            "Items",
            Icons.Default.FormatListBulleted,
            NewsRoute.ITEMS
        ),
        BottomMenuContent(
            "Profile",
            Icons.Default.Person,
            NewsRoute.PROFILE
        ),
    )

    fun getAllBottomMenuContent(): List<BottomMenuContent> = allBottomMenuContent
}