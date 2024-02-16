package com.example.jetpackcomposeuichallenge.presentation.common

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.EaseInBounce
import androidx.compose.animation.core.EaseOutBounce
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.progressSemantics
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeuichallenge.R
import com.example.jetpackcomposeuichallenge.ui.theme.JetpackComposeUIChallengeTheme
import com.example.jetpackcomposeuichallenge.ui.theme.transparentGrey
import java.lang.Math.abs
import kotlin.math.PI


/**
 * a method to add shimmer effect animation in
 * using an InfiniteTransition(Label = ""), with initial
 * Float Value of 0.2f and target Value of 0.9F and
 * Background Color of LightGray
 *
 */
fun Modifier.shimmerEffect() = composed {


    val transition = rememberInfiniteTransition(label = "")
    val scale = transition.animateFloat(
        initialValue = 0.7f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000)
        ),
        label = ""
    ).value


    val alpha = transition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.9f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000),
            repeatMode = RepeatMode.Restart

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
            .graphicsLayer {}
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
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .height(25.dp)
                        .shimmerEffect(),
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
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

@Composable
fun AnimateVisibility_() {
    var isVisible by remember { mutableStateOf(true) }
    val density = LocalDensity.current
    Column {

        val enabled by  remember{ mutableStateOf(false) }
        val alpha: Float by animateFloatAsState(
            targetValue = if (enabled) 1f else 0.5f,
            // Configure the animation duration and easing.
            animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing), label = ""
        )

        var animate by remember {
            mutableStateOf(false)
        }


        val size = animateDpAsState(
            targetValue =  if (animate) 50.dp else 8.dp, label = "",
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioHighBouncy,
                stiffness = Spring.StiffnessMediumLow
            )
        )



        AnimatedVisibility(
            visible = isVisible,
            enter = slideInVertically(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioHighBouncy,
                    stiffness = Spring.StiffnessLow
                )
            ),
            exit = slideOutVertically(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioHighBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        ) {
            Surface(
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .padding(horizontal = 4.dp),
                color = Color.Green

            ) {
                Column {

                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        Surface(
            modifier = Modifier
                .height(100.dp)
                .padding(horizontal = size.value)
                .fillMaxWidth()
                .clip(RoundedCornerShape(size.value))
                .background(color = Color.Blue)
                .clickable {
                    animate = !animate
                },
            color = Color.Blue

        ) {
            Column {

            }
        }
    }

}

@Composable
fun FlipCardDemo() {
    var flipped by remember { mutableStateOf(false) }
    val rotationZ by animateFloatAsState(targetValue = if (flipped) 270f else 0f, label = "",
        animationSpec = tween(durationMillis = 2000)
    )
    val translationX by animateFloatAsState(targetValue = if (flipped) 150f else 0f, label = "",
        animationSpec = tween(durationMillis = 2000)
    )

    val scaleX by animateFloatAsState(targetValue = if (flipped) 1.2f else 1f, label = "",
        animationSpec = tween(durationMillis = 2000)
    )
    val scaleY by animateFloatAsState(targetValue = if (flipped) 1.2f else 1f, label = "",
        animationSpec = tween(durationMillis = 2000)
    )

    AlatCustomLoader {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Card(
                modifier = Modifier
                    .graphicsLayer {

                        cameraDistance = 12f * density
                        shadowElevation = if (flipped) 0f else 30f
                        alpha = if (flipped) 0.1f else 0.1f
                        this.scaleY = scaleX
                        this.scaleX = scaleY

                    }
                    .clickable { flipped = !flipped }
                    .width(300.dp)
                    .height(200.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.DarkGray,
                )
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Hey bro", color = Color.White, fontSize = 32.sp)
                }
            }
        }

    }
}
@Composable
fun AlatCustomLoader(pulseFraction: Float = 1.2f, content: @Composable () -> Unit ) {

    val infiniteTransition = rememberInfiniteTransition()

    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = pulseFraction,
        animationSpec = infiniteRepeatable(animation = tween(1000),
            repeatMode = RepeatMode.Reverse), label = ""
    )
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White .copy(alpha = 0.6f)) {

        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.scale(scale)){
            content()
            CircularProgressbar3()
        }
    }


}


@Preview()
@Composable
fun PreviewFlippedCard(){
    JetpackComposeUIChallengeTheme {
        FlipCardDemo()

    }
}

@Composable
fun CircularProgressbar3(
    number: Float = 70f,
    numberStyle: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    ),
    size: Dp = 100.dp,
    indicatorThickness: Dp = 9.dp,
    animationDuration: Int = 1000,
    animationDelay: Int = 0,
    foregroundIndicatorColor: Color = Color.Red,
    backgroundIndicatorColor: Color = Color.Gray, numberR: Float= 10f
) {
    // It remembers the number value
    // var numberR by remember {
    // mutableStateOf(70f)
    // }
    val RotationsPerCycle = 5
    // Each rotation is 1 and 1/3 seconds, but 1332ms divides more evenly
    val RotationDuration = 1332
    // When the rotation is at its beginning (0 or 360 degrees) we want it to be drawn at 12 o clock,
    // which means 270 degrees when drawing.
    val StartAngleOffset = -90f
    // How far the base point moves around the circle
    val BaseRotationAngle = 286f
    // How far the head and tail should jump forward during one rotation past the base point
    val JumpRotationAngle = 290f
    // Each rotation we want to offset the start position by this much, so we continue where
    // the previous rotation ended. This is the maximum angle covered during one rotation.
    val RotationAngleOffset = (BaseRotationAngle + JumpRotationAngle) % 360f
    //val RotationDuration = 1332
    val HeadAndTailAnimationDuration = (RotationDuration * 0.5).toInt()
    val HeadAndTailDelayDuration = HeadAndTailAnimationDuration
    val CircularEasing = CubicBezierEasing(0.4f, 0f, 0.2f, 1f)
    //val transition = rememberInfiniteTransition()
    // The current rotation around the circle, so we know where to start the rotation from
    val transition = rememberInfiniteTransition()
    // The current rotation around the circle, so we know where to start the rotation from
    val currentRotation by transition.animateValue(
        0,
        RotationsPerCycle,
        Int.VectorConverter,
        infiniteRepeatable(
            animation = tween(
                durationMillis = RotationDuration * RotationsPerCycle,
                easing = LinearEasing
            )
        ), label = ""
    )
    // How far forward (degrees) the base point should be from the start point
    val baseRotation by transition.animateFloat(
        0f,
        BaseRotationAngle,
        infiniteRepeatable(
            animation = tween(
                durationMillis = RotationDuration,
                easing = LinearEasing
            )
        ), label = ""
    )
    // How far forward (degrees) both the head and tail should be from the base point
    val endAngle by transition.animateFloat(
        0f,
        JumpRotationAngle,
        infiniteRepeatable(
            animation = keyframes {
                durationMillis = HeadAndTailAnimationDuration + HeadAndTailDelayDuration
                0f at 0 with CircularEasing
                JumpRotationAngle at HeadAndTailAnimationDuration
            }
        ), label = ""
    )
    val startAngle by transition.animateFloat(
        0f,
        JumpRotationAngle,
        infiniteRepeatable(
            animation = keyframes {
                durationMillis = HeadAndTailAnimationDuration + HeadAndTailDelayDuration
                0f at HeadAndTailDelayDuration with CircularEasing
                JumpRotationAngle at durationMillis
            }
        ), label = ""
    )
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(size = size)
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(Color(0xFFD9D9D9))
        )
        Canvas(
            modifier = Modifier
                .progressSemantics()
                .size(size = size)
        ) {
            // Background circle
            drawCircle(
                color = backgroundIndicatorColor,
                radius = size.toPx() / 2,
                style = Stroke(width = indicatorThickness.toPx(), cap = StrokeCap.Round)
            )
            val currentRotationAngleOffset = (currentRotation * RotationAngleOffset) % 360f
            // How long a line to draw using the start angle as a reference point
            val sweep = abs(endAngle - startAngle)
            // Offset by the constant offset and the per rotation offset
            val offset = StartAngleOffset + currentRotationAngleOffset + baseRotation
            //val offset = StartAngleOffset + currentRotationAngleOffset + baseRotation
            this.drawIndeterminateCircularIndicator(startAngle + offset, indicatorThickness, sweep, foregroundIndicatorColor, Stroke(indicatorThickness.toPx(), cap = StrokeCap.Round))
        }
        Image(painter = painterResource(id = R.drawable.ic_alat_logo), contentDescription = null )
    }

}


private fun DrawScope.drawIndeterminateCircularIndicator(
    startAngle: Float,
    strokeWidth: Dp,
    sweep: Float,
    color: Color,
    stroke: Stroke
) {
    val CircularIndicatorDiameter = 40.dp
    // Length of arc is angle * radius
    // Angle (radians) is length / radius
    // The length should be the same as the stroke width for calculating the min angle
    val squareStrokeCapOffset =
        (180.0 / PI).toFloat() * (strokeWidth / (CircularIndicatorDiameter / 2)) / 2f

    // Adding a square stroke cap draws half the stroke width behind the start point, so we want to
    // move it forward by that amount so the arc visually appears in the correct place
    val adjustedStartAngle = startAngle + squareStrokeCapOffset

    // When the start and end angles are in the same place, we still want to draw a small sweep, so
    // the stroke caps get added on both ends and we draw the correct minimum length arc
    val adjustedSweep = kotlin.math.max(sweep, 0.1f)

    this.drawCircularIndicator(adjustedStartAngle, adjustedSweep, color, stroke)
}


fun DrawScope.drawCircularIndicator(
    adjustedStartAngle: Float,
    adjustedSweep: Float,
    color: Color,
    stroke: Stroke
) {

        drawArc(
            color = color,
            startAngle = adjustedStartAngle,
            sweepAngle = adjustedSweep,
            style = stroke,
            useCenter = false,
        )

    //Circulator

}


@Preview(showBackground = true)
@Composable
fun PreviewAnimatedVisibility() {
    JetpackComposeUIChallengeTheme {
        AnimateVisibility_()
    }
}

@Preview(showBackground = true)
@Composable
fun ShimmerEffectPreview() {
    JetpackComposeUIChallengeTheme {
        NewsCardShimmerEffect()
    }
}