package com.example.jetpackcomposeuichallenge.onboarding.ui

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.compose.JetpackComposeUIChallengeTheme
import com.example.compose.faintRed
import com.example.compose.transparentGrey
import com.example.jetpackcomposeuichallenge.data.local.OnBoarding
import com.example.jetpackcomposeuichallenge.data.local.OnBoardingDataProvider
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    navigateToChooseRolesScreen: (OnBoardingEvent) -> Unit
) {


    val pagerState = rememberPagerState(
        initialPage = 0,
    )
    val items = OnBoardingDataProvider.getOnboardingData()

    OnBoardingPager(
        item = items,
        pagerState = pagerState,
        navigateToChooseRolesScreen = navigateToChooseRolesScreen
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingPager(
    item: List<OnBoarding>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    navigateToChooseRolesScreen: (OnBoardingEvent) -> Unit
) {
    val viewModel : OnBoardingViewModel = hiltViewModel()

    Box(
        modifier = modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.systemBars)
            .fillMaxHeight()
            .padding(0.dp)
    ) {
        HorizontalPager(pageCount = item.size, state = pagerState) {

            val pageOffset = (pagerState.currentPage - it) * pagerState.currentPageOffsetFraction
            val imageSize by animateFloatAsState(
                targetValue = if (pageOffset != 0.0f) 0.70f else 1f,
                label = "",
                animationSpec = tween(durationMillis = 300)
            )
            val matrix = remember { ColorMatrix() }

            LaunchedEffect(
                key1 = Unit,
                block = {
                    repeat(
                        times = Int.MAX_VALUE,
                        action = {
                            delay(
                                timeMillis = 4000
                            )
                            try {
                                pagerState.animateScrollToPage(
                                    page = pagerState.currentPage + 1
                                )
                            } catch (_: Throwable) {
                            }
                        }
                    )
                })

            LaunchedEffect(key1 = imageSize) {
                if (pageOffset != 0.0f) {
                    matrix.setToSaturation(0.0f)
                } else matrix.setToSaturation(1.0f)
            }
            ConstraintLayout(modifier = modifier.fillMaxSize()) {

                val (image, button, newsHeadLine, skip, pagerIndicator) = createRefs()

                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp)
                        .graphicsLayer {
                            scaleX = imageSize
                            scaleY = imageSize
                        }
                        .padding(top = 40.dp, start = 16.dp, end = 16.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .constrainAs(image) {
                        },
                    painter = painterResource(id = item[it].image),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    colorFilter = ColorFilter.colorMatrix(matrix)
                )

                //description
                Text(
                    modifier = modifier
                        .graphicsLayer {
                            translationY = imageSize
                            translationX = imageSize
                        }
                        .constrainAs(newsHeadLine) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(image.bottom)
                            bottom.linkTo(pagerIndicator.top)
                        }
                        .padding(start = 16.dp, bottom = 16.dp),
                    text = item[it].description,
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                )

                PagerIndicator(
                    item.size, pagerState.currentPage,
                    modifier = modifier
                        .padding(start = 16.dp, bottom = 16.dp)
                        .constrainAs(pagerIndicator) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(skip.top)
                        })


                //skip
                Text(
                    modifier = modifier
                        .constrainAs(skip) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(button.top)
                        }
                        .clickable { }
                        .padding(start = 16.dp, bottom = 16.dp),
                    text = "Skip",
                    style = TextStyle(
                        color = faintRed,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 16.sp
                    )
                )


                //Button
                Button(modifier = modifier
                    .fillMaxWidth()
                    .constrainAs(button) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
                    .padding(start = 32.dp, bottom = 32.dp, end = 32.dp),
                    onClick = {
                        if (pagerState.currentPage == item.size-1) {
                            viewModel.onEvent(OnBoardingEvent.SaveAppEntry)
                            navigateToChooseRolesScreen(OnBoardingEvent.SaveAppEntry)
                        } else {

                        }
                    },
                    shape = RoundedCornerShape(32.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = faintRed
                    )
                ) {
                    Text(text = "Next", style = TextStyle(color = Color.White))
                }

            }
        }
    }
}


@Composable
fun PagerIndicator(size: Int, currentPage: Int, modifier: Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(size) {
            Indicator(isSelected = it == currentPage)
        }

    }
}

@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(targetValue = if (isSelected) 25.dp else 10.dp, label = "")

    Box(
        Modifier
            .padding(4.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) faintRed else transparentGrey
            )
    ) {

    }
}


@Preview()
@Composable
fun PreviewOnboarding() {

    JetpackComposeUIChallengeTheme {
        OnBoardingScreen(navigateToChooseRolesScreen = {})
    }

}



