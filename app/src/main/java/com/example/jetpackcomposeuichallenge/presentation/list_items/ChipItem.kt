package com.example.jetpackcomposeuichallenge.presentation.list_items

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.compose.faintRed

@Composable
fun ChipItem(chips: List<String>, modifier: Modifier = Modifier) {
    var selectedChipIndex by remember { mutableStateOf(0) }

    LazyRow(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 8.dp)) {
        items(chips.size) {

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(32.dp))
                    .height(40.dp)
                    .padding(start = 15.dp, top = 8.dp, bottom = 8.dp, end = 16.dp)
                    .background(
                        color = if (selectedChipIndex == it) faintRed else Color.White,
                        shape = RoundedCornerShape(32.dp)
                    )
                    .border(1.dp, color = faintRed, shape = RoundedCornerShape(32.dp))
                    .clickable { selectedChipIndex = it },
                contentAlignment = Alignment.Center
            )
            {
                Text(
                    modifier = Modifier.padding(start = 15.dp, end = 16.dp),
                    text = chips[it],
                    style = TextStyle(color = if (selectedChipIndex == it) Color.White else faintRed)
                )
            }

        }
    }


}