package com.example.jetpackcomposeuichallenge.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.faintRed
import com.example.compose.lightRed

@Composable
fun CircularIconWithLightRedBg(imageVector: ImageVector ){

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .size(80.dp)
            .background(shape = CircleShape, color = lightRed)
    ) {
        Icon(
            modifier = Modifier
                .size(32.dp),
            imageVector = imageVector,
            tint = faintRed,
            contentDescription = ""
        )
    }
}