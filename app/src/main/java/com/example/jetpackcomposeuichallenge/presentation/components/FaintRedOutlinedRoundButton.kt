package com.example.jetpackcomposeuichallenge.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeuichallenge.ui.theme.faintRed

@Composable
fun FaintRedOutlinedRoundButton(
    height: Dp = 32.dp,
    buttonText: String,
    textSize: TextUnit = 12.sp
) {

    OutlinedButton(
        modifier = Modifier
            .height(height)
            .padding(horizontal = 8.dp),
        onClick = {},
        shape = RoundedCornerShape(32.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        ),
        border = BorderStroke(1.dp, color = faintRed)
    ) {
        Text(
            text = buttonText, style = TextStyle(color = faintRed),
            overflow = TextOverflow.Ellipsis, fontSize = textSize
        )
    }


}