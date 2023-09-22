package com.example.jetpackcomposeuichallenge.items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
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
import com.example.compose.transparentGrey
import com.example.jetpackcomposeuichallenge.data.PeopleAvailableProvider

@Composable
fun PeopleItem(
    people: PeopleAvailableProvider.People,
    isSelected: Boolean,
    state: LazyListState,
    navigateToDetails: () -> Unit,
) {

    Card(
        modifier = Modifier
            .graphicsLayer {
            }
            .height(100.dp)
            .fillMaxWidth()
            .background(color = Color.Transparent)
            .padding(horizontal = 4.dp, vertical = 4.dp)
            .semantics { selected = isSelected },
        shape = RoundedCornerShape(16.dp),
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
                    .padding(16.dp)
                    .fillMaxHeight()
                    .weight(1.0f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(60.dp)
                        .fillMaxHeight(1.0f)
                        .fillMaxWidth(),
                    painter = painterResource(id = people.newsAvatar),
                    contentScale = ContentScale.Crop,
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.width(20.dp))

                Column(
                    modifier = Modifier.padding(8.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = people.newsChannel,
                        style = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    )
                    Text(
                        text = people.peopleFollowing,
                        style = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp
                        )
                    )
                }
            }


            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(32.dp))
                    .height(40.dp)
                    .padding(start = 15.dp, top = 8.dp, bottom = 8.dp, end = 16.dp)
                    .background(
                        color = if (people.hasFollowed) Color.White else faintRed,
                        shape = RoundedCornerShape(32.dp)
                    )
                    .border(1.dp, color = faintRed, shape = RoundedCornerShape(32.dp))
                    .clickable { },
                contentAlignment = Alignment.CenterStart
            )
            {
                Text(
                    modifier = Modifier.padding(start = 15.dp, end = 16.dp),
                    text = if (people.hasFollowed) "Following" else "Follow",
                    style = TextStyle(color = if (people.hasFollowed) faintRed else Color.White)
                )
            }

        }
    }

}