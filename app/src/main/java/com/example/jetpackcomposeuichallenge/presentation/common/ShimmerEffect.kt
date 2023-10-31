package com.example.jetpackcomposeuichallenge.presentation.common

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.JetpackComposeUIChallengeTheme
import com.example.compose.transparentGrey


/**
 * a method to add shimmer effect animation in
 * using an InfiniteTransition(Label = ""), with initial
 * Float Value of 0.2f and target Value of 0.9F and
 * Background Color of LightGray
 *
 */
fun Modifier.shimmerEffect() = composed {
    val transition = rememberInfiniteTransition(label = "")
    val alpha = transition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.9f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000)
        ), label = ""
    ).value
    background(color = Color.LightGray.copy(alpha = alpha))
}





/**
 * Shimmer Effect for NewsList Items
 */
@Composable
fun NewsCardShimmerEffect(modifier: Modifier = Modifier) {

    Card(
        modifier = Modifier
            .graphicsLayer {
            }
            .height(200.dp)
            .fillMaxWidth()
            .background(color = Color.Transparent)
            .padding(horizontal = 4.dp, vertical = 4.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        border = BorderStroke(1.dp, color = transparentGrey),
        elevation = CardDefaults.outlinedCardElevation(
            pressedElevation = 8.dp
        )

    ) {
        Row() {

            Box(modifier = Modifier.weight(.42f)) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxHeight(1.0f)
                        .fillMaxWidth()
                        .shimmerEffect()
                )
            }

            Column(
                modifier = Modifier
                    .weight(.55f)
                    .padding(top = 8.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceAround
            ) {

                Box(
                    modifier = Modifier.padding(8.dp).fillMaxWidth().height(25.dp).shimmerEffect(),
                )


                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.padding(horizontal = 4.dp)
                ) {
                    Box(
                        modifier = modifier
                            .clip(CircleShape)
                            .size(32.dp)
                            .shimmerEffect()
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .width(40.dp)
                            .height(32.dp)
                            .shimmerEffect()
                    )

                    Spacer(modifier = Modifier.width(18.dp))

                    Box(
                        modifier = Modifier
                            .height(32.dp)
                            .width(60.dp)
                            .shimmerEffect()
                            .clip(
                                RoundedCornerShape(32.dp)
                            )
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth() .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .height(20.dp)
                            .width(30.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .shimmerEffect()
                    )

                    Box(
                        modifier = Modifier
                            .height(20.dp)
                            .width(30.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .shimmerEffect()
                    )

                    Box(
                        modifier = Modifier
                            .height(20.dp)
                            .width(30.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .shimmerEffect()
                    )
                }

            }


        }

    }

}

@Preview(showBackground = true)
@Composable
fun ShimmerEffectPreview(){
    JetpackComposeUIChallengeTheme {
        NewsCardShimmerEffect()
    }
}