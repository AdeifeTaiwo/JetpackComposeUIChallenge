package com.example.jetpackcomposeuichallenge

import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performScrollToIndex
import androidx.compose.ui.test.printToLog
import com.example.jetpackcomposeuichallenge.di.AppModule
import com.example.jetpackcomposeuichallenge.domain.model.Article
import com.example.jetpackcomposeuichallenge.domain.model.Source
import com.example.jetpackcomposeuichallenge.presentation.common.HomeScreen
import com.example.jetpackcomposeuichallenge.presentation.home.HomeViewModel
import com.example.jetpackcomposeuichallenge.presentation.home.NewsHomeScreen
import com.example.jetpackcomposeuichallenge.presentation.onBoarding.OnBoardingScreen
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
@HiltAndroidTest()
@UninstallModules(AppModule::class)
class HomeScreenUiTest {


    @get: Rule(order = 1)
    var hiltTestRule = HiltAndroidRule(this)

    @get: Rule(order = 2)
    var composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        hiltTestRule.inject()

        composeTestRule.activity.setContent {
            NewsHomeScreen(name = "Taiwo",
                viewModel = composeTestRule.activity.viewModels<HomeViewModel>().value,
                onClickSeeAllFeaturedNews = {
                }, onNotificationIconClicked = {}) {

            }

        }
    }



    @Test
    fun enterSearchEditText_showsEditText() {
        composeTestRule.mainClock.autoAdvance = false

        composeTestRule.onNode(hasText("Berita") and hasContentDescription("Notification Icon"))

        composeTestRule.mainClock.advanceTimeByFrame()



        composeTestRule.mainClock.advanceTimeBy(5000)

        composeTestRule.onNodeWithTag("SeeNewsTag").performClick()

        composeTestRule.mainClock.advanceTimeBy(5000)

        composeTestRule.onNodeWithText("Latest").assertExists()

        composeTestRule.onNodeWithTag("FeaturedRowTag").performScrollToIndex(3).assertIsDisplayed()



        composeTestRule.onRoot().printToLog("TAG")


    }
}

val dummyItem = listOf<Article>(
    Article(
        author = "Taiwo",
        content = "Hello",
        description = "Nigeria beats china",
        publishedAt = "144343",
        source = Source(id = "1", name = "BBC"),
        url = "",
        urlToImage = "",
        title = "Ololade gbomo lo"
    )
)