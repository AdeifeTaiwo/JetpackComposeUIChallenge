package com.example.jetpackcomposeuichallenge.searchnews

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.compose.faintRed
import com.example.jetpackcomposeuichallenge.EmptyComingSoon
import com.example.jetpackcomposeuichallenge.components.AppSearchBar
import com.example.jetpackcomposeuichallenge.components.BackButtonWithMenuIcon
import com.example.jetpackcomposeuichallenge.data.local.ChipData
import com.example.jetpackcomposeuichallenge.data.local.PeopleAvailableProvider
import com.example.jetpackcomposeuichallenge.items.ChipItem
import com.example.jetpackcomposeuichallenge.items.PeopleItem
import com.example.jetpackcomposeuichallenge.notification.NotificationScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchNewsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars)
    ) {
        val coroutineScope = rememberCoroutineScope()
        val pagerState = rememberPagerState()

        Spacer(modifier = Modifier.height(20.dp))

        BackButtonWithMenuIcon(headerText = "Search News", menuIcon = null)

        Spacer(modifier = Modifier.height(0.dp))

        AppSearchBar()

        Spacer(modifier = Modifier.height(16.dp))

        TabRow(
            contentColor = Color.Transparent.copy(0.1f),
            modifier = Modifier,
            selectedTabIndex = pagerState.currentPage,
            containerColor = Color.White,
            indicator = { tabPositions ->

                val transition = updateTransition(targetState = pagerState.currentPage, label = "")
                val indicatorStart by transition.animateDp(
                    transitionSpec = {
                        if (initialState < targetState) {
                            spring(dampingRatio = 1f, stiffness = 50f)//Using spring
                        } else {
                            spring(
                                dampingRatio = 1f,
                                stiffness = 100f
                            )//Change stiffness according to your need
                        }
                    }, label = ""
                ) {
                    tabPositions[it].left
                }

                val indicatorEnd by transition.animateDp(//Indicator end transition animation
                    transitionSpec = {
                        if (initialState < targetState) {
                            spring(
                                dampingRatio = 1f,
                                stiffness = 100f
                            )//Or you can change your anim here
                        } else {
                            spring(dampingRatio = 1f, stiffness = 50f)
                        }
                    }, label = ""
                ) {
                    tabPositions[it].right
                }

                Box(
                    modifier = Modifier
                        .offset(x = indicatorStart)
                        .wrapContentSize(align = Alignment.BottomStart)
                        .width(indicatorEnd - indicatorStart)
                        .height(2.dp)
                        .border(2.dp, faintRed)
                ) {

                }
            }) {
            TabItems.allTabItems.forEachIndexed { index, tabItem ->
                Tab(
                    text = {
                        Text(
                            text = tabItem.text,
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        )
                    },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    })
            }
        }

        val peopleLazyList = rememberLazyListState()
        Spacer(modifier = Modifier.height(20.dp))
        ChipItem(chips = ChipData.getAllNewsChipItem())
        Spacer(modifier = Modifier.height(16.dp))

        HorizontalPager(
            pageCount = TabItems.allTabItems.size,
            state = pagerState,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .height(700.dp)
                .fillMaxSize()
                .fillMaxHeight()
        ) {

            when (pagerState.currentPage) {
                0 -> NotificationScreen(modifier = modifier)
                1 -> {
                    val allPeople = PeopleAvailableProvider.getAvailablePeople()
                    Column(modifier = Modifier) {

                        LazyColumn {
                            items(items = allPeople, key = { it.id }) { people ->
                                PeopleItem(
                                    people = people,
                                    isSelected = true,
                                    state = peopleLazyList
                                ) {}

                            }

                        }
                    }


                }

                2 -> EmptyComingSoon(modifier = modifier)
            }

        }

    }
}

object TabItems {
    val allTabItems = listOf(
        TabItem("News",
            screen = {
                EmptyComingSoon(modifier = Modifier)
            }
        ),
        TabItem("People",
            screen = {
                EmptyComingSoon(modifier = Modifier)
            }
        ),
        TabItem("HashTags",
            screen = {
                EmptyComingSoon(modifier = Modifier)
            }
        )

    )
}

data class TabItem(
    val text: String,
    val screen: @Composable () -> Unit
)