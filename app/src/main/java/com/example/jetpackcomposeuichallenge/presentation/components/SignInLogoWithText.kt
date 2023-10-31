package com.example.jetpackcomposeuichallenge.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.faintRed
import com.example.compose.transparentGrey
import com.example.jetpackcomposeuichallenge.R

@Composable
fun SignInLogoWithText(modifier: Modifier = Modifier, logo: Int, logoName: String) {

    Card(
        modifier = modifier
            .graphicsLayer {}
            .height(70.dp)
            .fillMaxWidth()
            .background(color = Color.Transparent)
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .semantics { },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        border = BorderStroke(
            1.dp,
            color = transparentGrey
        ),

        elevation = CardDefaults.outlinedCardElevation(
            pressedElevation = 0.dp
        )

    ) {

        Row(
            modifier = Modifier
                .padding(8.dp)
                .clickable { }
                .weight(1.0f),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                modifier = modifier.size(48.dp),
                painter = painterResource(id = logo),
                contentDescription = logoName,
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.width(4.dp))

            Text(
                modifier = modifier,
                text = logoName,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )

        }
    }

}