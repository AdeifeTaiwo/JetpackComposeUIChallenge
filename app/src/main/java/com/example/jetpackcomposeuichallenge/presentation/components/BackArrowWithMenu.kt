package com.example.jetpackcomposeuichallenge.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeuichallenge.ui.theme.faintRed

@Composable
fun BackButtonWithMenuIcon(
    modifier: Modifier = Modifier,
    headerText: String,
    menuIcon: ImageVector? = null
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(modifier = modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                tint = faintRed
            )
            Spacer(modifier.width(16.dp))
            Text(
                text = headerText,
                style = TextStyle(
                    color = Color.Companion.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )
        }
        if(menuIcon!=null)
        RoundedIconWithLightRedBackground(imageVector = menuIcon) {

        }

    }

}