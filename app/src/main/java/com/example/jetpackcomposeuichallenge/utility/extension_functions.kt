package com.example.jetpackcomposeuichallenge.utility

import androidx.compose.foundation.lazy.LazyListLayoutInfo
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController


// Returns the normalized center item offset (-1,1)
fun LazyListLayoutInfo.normalizedItemPosition(key: Any): Float =
    visibleItemsInfo
        .firstOrNull { it.key == key }
        ?.let {
            val center = (viewportEndOffset + viewportStartOffset)
            (it.offset.toFloat() - center) / center

        } ?: 0F

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(this@navigateSingleTopTo.graph.findStartDestination().id) {
            saveState = false
        }
        launchSingleTop = true
        restoreState = true
    }

fun NavHostController.navigateSingleTopNoPopUpToHome(route: String) =
    this.navigate(route) {
        popUpTo(this@navigateSingleTopNoPopUpToHome.graph.findNode(route)!!.id) {
            saveState = false
        }
        launchSingleTop = true
        restoreState = true
    }