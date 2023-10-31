package com.example.jetpackcomposeuichallenge.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.decode.SvgDecoder
import com.example.compose.faintRed
import com.example.compose.lightRed
import com.example.jetpackcomposeuichallenge.R

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ThreeLinesIcon() {

    val imageLoader = ImageLoader.Builder(LocalContext.current).components {
        (SvgDecoder(LocalContext.current))
    }.build()

    val painter = rememberImagePainter(R.drawable.three_lines, imageLoader)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .size(40.dp)
            .background(shape = RoundedCornerShape(8.dp), color = lightRed)
    ) {

        Image(
            painter = painter,
            modifier = Modifier
                .size(32.dp),
            contentDescription = ""
        )
    }
}