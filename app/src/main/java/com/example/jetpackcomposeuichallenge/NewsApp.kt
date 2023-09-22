package com.example.jetpackcomposeuichallenge

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeuichallenge.components.BottomMenu
import com.example.jetpackcomposeuichallenge.data.BottomMenuProvider
import com.example.jetpackcomposeuichallenge.extensions.NewsRoute
import com.example.jetpackcomposeuichallenge.extensions.navigateSingleTopTo
import com.example.jetpackcomposeuichallenge.home.FeaturedNews
import com.example.jetpackcomposeuichallenge.home.NewsHomeScreen
import com.example.jetpackcomposeuichallenge.notification.NotificationScreen
import com.example.jetpackcomposeuichallenge.searchnews.SearchNewsScreen


@Composable
fun NewsApp(modifier: Modifier = Modifier) {

    Column(modifier = modifier.fillMaxSize()) {
        val navController = rememberNavController()
        val selectedDestination = remember { mutableStateOf(NewsRoute.HOME) }
        val items = BottomMenuProvider.getAllBottomMenuContent()

        MyAppNavHost(
            navController = navController,
            modifier = modifier
                .padding(0.dp)
                .weight(1f),
        )

        BottomMenu(
            items = items,
            modifier = modifier
        ) {
            selectedDestination.value = items[it].route
            navController.navigateSingleTopTo(items[it].route)
        }
    }
}


@Composable
fun MyAppNavHost(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = NewsRoute.HOME,
        modifier = modifier
    ) {

        composable(route = NewsRoute.HOME) {
            NewsHomeScreen(
                name = "Taiwo",
                modifier = modifier,
                onClickSeeAllFeaturedNews = { navController.navigateSingleTopTo(it) },
                onNotificationIconClicked = {navController.navigateSingleTopTo(NewsRoute.NOTIFICATION)}
            )
        }

        composable(route = NewsRoute.SEARCH) {
            SearchNewsScreen(modifier = modifier)
        }

        composable(route = NewsRoute.BOOKMARK) {
            EmptyComingSoon(modifier = Modifier)
        }

        composable(route = NewsRoute.ITEMS) {
            EmptyComingSoon(modifier = Modifier)
        }

        composable(route = NewsRoute.PROFILE) {
            EmptyComingSoon(modifier = Modifier)
        }
        composable(route = NewsRoute.FEATURED_NEWS) {
            FeaturedNews(modifier = modifier)
        }

        composable(route = NewsRoute.NOTIFICATION) {
            NotificationScreen(modifier = modifier)
        }

        composable(route = NewsRoute.SEARCH_NEWS) {
            SearchNewsScreen(modifier = modifier)
        }

    }

}