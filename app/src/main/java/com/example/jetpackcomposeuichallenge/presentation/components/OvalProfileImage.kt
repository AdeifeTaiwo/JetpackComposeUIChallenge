package com.example.jetpackcomposeuichallenge.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun OvalProfileImage(
    drawableResource: Int,
    description: String,
    modifier: Modifier = Modifier,
    size : Dp = 32.dp
) {
    Image(
        modifier = modifier
            .clip(CircleShape)
            .size(size),
        painter = painterResource(id = drawableResource),
        contentDescription = description,
        contentScale = ContentScale.FillBounds
    )
}