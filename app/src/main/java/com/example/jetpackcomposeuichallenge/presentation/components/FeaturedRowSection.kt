package com.example.jetpackcomposeuichallenge.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeuichallenge.ui.theme.faintRed

@Composable
fun FeaturedRow(
    modifier: Modifier = Modifier,
    item: String = "Featured",
    onClickSeeAllText: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier,
            text = item,
            style = TextStyle (
                color = Color.Black,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp
            )
        )

        Text(
            modifier = modifier.clickable {
                onClickSeeAllText(item)
            },
            text = "See all",
            style = TextStyle(
                color = faintRed,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 14.sp
            )
        )

    }
}