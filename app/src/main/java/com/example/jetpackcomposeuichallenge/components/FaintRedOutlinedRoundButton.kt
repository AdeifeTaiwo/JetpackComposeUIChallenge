package com.example.jetpackcomposeuichallenge.components

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
import androidx.compose.ui.unit.dp
import com.example.compose.faintRed

@Composable
fun FaintRedOutlinedRoundButton(buttonText: String) {

    OutlinedButton(
        modifier = Modifier.height(32.dp)
            .padding(horizontal = 8.dp),
        onClick = {},
        shape = RoundedCornerShape(32.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        ),
        border = BorderStroke(1.dp, color = faintRed)
    ) {
        Text(text = buttonText, style = TextStyle(color = faintRed))
    }


}