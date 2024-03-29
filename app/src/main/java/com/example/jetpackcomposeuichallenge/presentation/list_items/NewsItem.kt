package com.example.jetpackcomposeuichallenge.presentation.list_items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.ThumbUp
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.jetpackcomposeuichallenge.ui.theme.transparentGrey
import com.example.jetpackcomposeuichallenge.presentation.components.FaintRedOutlinedRoundButton
import com.example.jetpackcomposeuichallenge.presentation.components.OvalProfileImage
import com.example.jetpackcomposeuichallenge.R
import com.example.jetpackcomposeuichallenge.domain.model.Article
import com.example.jetpackcomposeuichallenge.presentation.components.IconWithText

@Composable
fun NewsListItem(
    news: Article,
    isSelected: Boolean,
    state: LazyListState,
    navigateToDetails: (Article) -> Unit,
) {

    Card(
        modifier = Modifier
            .graphicsLayer {
            }
            .height(200.dp)
            .clickable {
                navigateToDetails(news)
            }
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
        Row() {

            Column(modifier = Modifier.weight(.42f)) {

                val context = LocalContext.current

                AsyncImage(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxHeight(1.0f)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop,
                    model = ImageRequest.Builder(context = context).data(news.urlToImage).build(),
                    contentDescription = null
                )
            }

            Column(modifier = Modifier
                .weight(.55f)
                .padding(top = 8.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceAround) {

                Text(
                    modifier = Modifier.padding(8.dp),
                    text = news.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
                )


                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.padding(horizontal = 4.dp)
                ) {
                    OvalProfileImage(drawableResource = R.drawable.bg_7, description = "" )
                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        modifier = Modifier.padding(8.dp).width(50.dp),
                        text = news.source.name,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    FaintRedOutlinedRoundButton(buttonText = news.setGenr())

                }

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    IconWithText(icon = Icons.Default.ThumbUp, selectedIcon = Icons.Default.ThumbUp, text = "361.4k")

                    IconWithText(icon = Icons.Default.FavoriteBorder, selectedIcon = Icons.Default.Favorite, text = "31.4k")

                    IconWithText(icon = Icons.Default.DateRange, selectedIcon = Icons.Default.DateRange, text = "")
                }

            }


        }

    }
}
