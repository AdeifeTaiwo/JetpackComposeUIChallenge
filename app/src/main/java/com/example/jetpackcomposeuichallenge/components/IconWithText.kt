package com.example.jetpackcomposeuichallenge.components

import android.widget.Space
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.compose.faintRed
import com.example.compose.lightRed


@Composable
fun IconWithText(icon: ImageVector, selectedIcon: ImageVector, text: String) {

    var toggled by remember { mutableStateOf(false) }

    val animatedColor by animateColorAsState(
        if (toggled) {
            faintRed
        } else lightRed,
        label = ""
    )

    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            modifier = Modifier
                .clickable {
                    toggled = !toggled
                }
                .padding(start = 8.dp)
                .size(20.dp),
            imageVector = if(toggled) selectedIcon else icon,
            contentDescription = "",
            tint = animatedColor
        )
        Spacer(modifier = Modifier.padding(horizontal = 4.dp))
        Text(text = text, style = TextStyle(color = Color.Black))


    }
}