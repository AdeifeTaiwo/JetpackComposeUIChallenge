package com.example.jetpackcomposeuichallenge.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeuichallenge.ui.theme.faintRed
import com.example.jetpackcomposeuichallenge.ui.theme.lightRed

@Composable
fun RoundedIconWithLightRedBackground(size: Dp = 40.dp, imageVector: ImageVector, onIconClicked: () -> Unit) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable {
            onIconClicked()
        }
            .padding(8.dp)
            .size(size)
            .background(shape = RoundedCornerShape(8.dp), color = lightRed)
    ) {

        Icon(
            modifier = Modifier
                .size(24.dp),
            imageVector = imageVector,
            tint = faintRed,
            contentDescription = "Notification Icon"
        )
    }
}