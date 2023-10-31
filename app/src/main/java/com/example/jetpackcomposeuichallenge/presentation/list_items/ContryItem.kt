package com.example.jetpackcomposeuichallenge.presentation.list_items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.faintRed
import com.example.compose.lightRed
import com.example.compose.transparentGrey
import com.example.jetpackcomposeuichallenge.data.local.Country

@Composable
fun CountryItem(
    item: Country,
    isSelected: Boolean = false,
    activeHighlightColor: Color = faintRed,
    activeTextColor: Color = Color.White,
    inActiveTextColor: Color = lightRed,
    onItemClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .graphicsLayer {
            }
            .height(90.dp)
            .fillMaxWidth()
            .background(color = Color.Transparent)
            .padding(horizontal = 4.dp, vertical = 4.dp)
            .semantics { selected = isSelected },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        border = BorderStroke(1.dp, color = transparentGrey),
        elevation = CardDefaults.outlinedCardElevation(
            pressedElevation = 8.dp
        )

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxHeight()
                    .weight(0.8f),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(
                    modifier = Modifier.weight(1.0f).padding(start = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Image(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .size(40.dp)
                            .fillMaxHeight(1.0f)
                            .fillMaxWidth(),
                        painter = painterResource(id = item.flag),
                        contentScale = ContentScale.Crop,
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.width(20.dp))


                    Text(
                        text = item.countryCode,
                        style = TextStyle(
                            color = Color.Gray,
                            fontWeight = FontWeight.Black,
                            fontSize = 14.sp
                        )
                    )

                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = item.countryName,
                        style = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    )
                }

            }



            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(40.dp)
                    .padding(8.dp)
                    .background(
                        color = Color.Transparent
                    )
                    .border(1.dp, color = faintRed, shape = RoundedCornerShape(32.dp))
                    .clickable {
                        onItemClick()
                    },
                contentAlignment = Alignment.Center
            )
            {

                if (isSelected) {
                    Box(
                        modifier = Modifier
                            .background(color = faintRed, shape = CircleShape)
                            .size(15.dp)
                    )
                }
            }

        }
    }

}