package com.example.jetpackcomposeuichallenge.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeuichallenge.ui.theme.disabledBtnColor
import com.example.jetpackcomposeuichallenge.ui.theme.faintRed

@Composable
fun ContinueButtonComponent(
    modifier: Modifier = Modifier,
    buttonText: String = "Continue",
    enabled: Boolean = false,
    onContinueButtonClick: () -> Unit
) {

    OutlinedButton(
        modifier = modifier
            .height(50.dp)
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        onClick = {
            onContinueButtonClick()
        },
        enabled = enabled,
        shape = RoundedCornerShape(32.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (enabled) faintRed else disabledBtnColor,
            disabledContainerColor = disabledBtnColor
        ),
        border = BorderStroke(1.dp, color = Color.Transparent)
    ) {
        Text(
            text = buttonText,
            style = TextStyle(color = Color.White, fontSize = 16.sp))
    }
}