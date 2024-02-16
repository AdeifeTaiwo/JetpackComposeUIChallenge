package com.example.jetpackcomposeuichallenge.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeuichallenge.ui.theme.faintRed
import com.example.jetpackcomposeuichallenge.ui.theme.transparentGrey
import com.example.jetpackcomposeuichallenge.data.local.BottomMenuContent
import com.example.jetpackcomposeuichallenge.presentation.list_items.BottomMenuItem


@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = faintRed,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = Color.Black,
    initialSelectedItemIndex: Int = 0,
    onItemClick: (Int) -> Unit
) {

    var selectedItemIndex by remember { mutableStateOf(initialSelectedItemIndex) }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
            .clip( RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .border(width = 1.dp, color = transparentGrey)
            .padding(15.dp)

    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = (index == selectedItemIndex),
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inActiveTextColor = inactiveTextColor,
                onItemClick = {
                    selectedItemIndex = index
                    onItemClick(selectedItemIndex)
                }

            )
        }
    }

}

