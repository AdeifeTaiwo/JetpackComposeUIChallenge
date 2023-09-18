package com.example.jetpackcomposeuichallenge.items

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.compose.faintRed
import com.example.jetpackcomposeuichallenge.R
import com.example.jetpackcomposeuichallenge.data.News
import com.example.jetpackcomposeuichallenge.extensions.normalizedItemPosition
import kotlin.math.absoluteValue


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FeaturedRowItem(
    news: News,
    isSelected: Boolean,
    state: LazyListState,
    modifier: Modifier = Modifier, navigateToDetails: () -> Unit
) {
    var scale by remember {
        mutableStateOf(1.0f)
    }

    val configuration = LocalConfiguration.current

    val widthInDp = configuration.screenWidthDp.dp
    val heightInDp = configuration.screenHeightDp.dp



    Box(
        modifier = modifier
            .graphicsLayer {
                alpha =  state.layoutInfo.normalizedItemPosition(news.id).absoluteValue
            }

            .width(widthInDp -30.dp)
            .height(280.dp)
            .padding(4.dp)
            .background(color = Color.Transparent, shape = RoundedCornerShape(8.dp))
    ) {

        ConstraintLayout(modifier = modifier.fillMaxSize()) {

            val (image, button, newsHeadLine) = createRefs()

            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp))
                    .constrainAs(image) {

                    },
                painter = painterResource(id = news.images),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )

            Text(
                modifier = modifier
                    .constrainAs(newsHeadLine) {
                        start.linkTo(parent.start)
                        bottom.linkTo(button.top)
                    }
                    .padding(start = 16.dp, bottom = 16.dp),
                text = "Joe Biden in Press Conference USA",
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp
                )
            )

            //Button
            Button(modifier = modifier
                .constrainAs(button) {
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                }
                .padding(start = 16.dp, bottom = 16.dp),
                onClick = {},
                shape = RoundedCornerShape(32.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = faintRed
                )
            ) {
                Text(text = "Read now", style = TextStyle(color = Color.White))
            }

        }
    }
}