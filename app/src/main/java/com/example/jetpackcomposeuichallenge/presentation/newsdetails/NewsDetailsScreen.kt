package com.example.jetpackcomposeuichallenge.presentation.newsdetails

import android.content.Intent
import android.net.Uri
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.ThumbDown
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.compose.JetpackComposeUIChallengeTheme
import com.example.compose.faintRed
import com.example.jetpackcomposeuichallenge.R
import com.example.jetpackcomposeuichallenge.domain.model.Article
import com.example.jetpackcomposeuichallenge.presentation.components.BackButtonWithBookMarkIcon
import com.example.jetpackcomposeuichallenge.presentation.components.BackButtonWithMenuIcon
import com.example.jetpackcomposeuichallenge.presentation.components.FaintRedOutlinedRoundButton
import com.example.jetpackcomposeuichallenge.presentation.components.IconWithText
import com.example.jetpackcomposeuichallenge.presentation.components.OvalProfileImage

@Composable
fun NewsDetailsScreen(
    modifier: Modifier = Modifier,
    news: Article? = null,
    onNavigateUp: () -> Unit

) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        BackButtonWithBookMarkIcon(headerText = "",
            onBookmarkClick = {

            },
            onBrowsingClick = {
                Intent(Intent.ACTION_VIEW).also {
                    it.data = Uri.parse(news?.url)
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            },
            onShareClick = {
                Intent(Intent.ACTION_SEND).also {
                    it.putExtra(Intent.EXTRA_TEXT, news?.url)
                    it.type = "text/plain"
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            }
        )

        Box(
            modifier = modifier
                .graphicsLayer {
                    //alpha = state.layoutInfo.normalizedItemPosition(news.id).absoluteValue
                }
                .fillMaxWidth()
                .height(400.dp - 20.dp)
                .padding(bottom = 16.dp, top = 16.dp)
                .background(color = Color.Transparent, shape = RoundedCornerShape(8.dp))
        ) {

            AsyncImage(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxHeight(1.0f)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop,
                model = ImageRequest.Builder(context = context).data(news?.urlToImage).build(),
                contentDescription = "News Image"
            )
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            text = news?.title?:"",
            overflow = TextOverflow.Ellipsis,
            maxLines = 3,
            style = TextStyle(
                fontWeight = FontWeight.W400,
                fontSize = 16.sp,
                fontStyle = FontStyle.Normal
            )
        )

        Row(
            modifier = Modifier.padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            FaintRedOutlinedRoundButton(height = 28.dp, buttonText = "Politics", textSize = 9.sp)
            IconWithText(
                icon = Icons.Default.VisibilityOff,
                selectedIcon = Icons.Default.Visibility,
                text = "638.6k"
            )
            IconWithText(
                icon = Icons.Default.ThumbUp,
                selectedIcon = Icons.Default.ThumbUp,
                text = "361.4k"
            )

            IconWithText(
                icon = Icons.Default.FavoriteBorder,
                selectedIcon = Icons.Default.Message,
                text = "31.4k"
            )
        }

        Spacer(modifier = Modifier.height(15.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {
                OvalProfileImage(size = 42.dp, drawableResource = R.drawable.bg_7, description = "")
                Column(
                    modifier = Modifier
                        .height(46.dp)
                        .padding(start = 4.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "Bbc News", fontSize = 14.sp, style = TextStyle(color = faintRed))
                    Text(text = "2 days ago", fontSize = 11.sp)

                }
            }
            val hasFollowed = false
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(32.dp))
                    .height(40.dp)
                    .padding(start = 15.dp, top = 8.dp, bottom = 8.dp, end = 16.dp)
                    .background(
                        color = if (hasFollowed) Color.White else faintRed,
                        shape = RoundedCornerShape(32.dp)
                    )
                    .border(1.dp, color = faintRed, shape = RoundedCornerShape(32.dp))
                    .clickable { },
                contentAlignment = Alignment.CenterStart
            )
            {
                Text(
                    modifier = Modifier.padding(start = 15.dp, end = 16.dp),
                    text = if (hasFollowed) "Following" else "Follow",
                    style = TextStyle(color = if (hasFollowed) faintRed else Color.White)
                )
            }

        }

        Spacer(modifier = Modifier.height(15.dp))
        Text(
            modifier = Modifier.padding(horizontal = 4.dp),
            text = news?.content?: stringResource(id = R.string.lorem_ipsum_1),
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                lineHeight = 20.sp
            )
        )

        Spacer(modifier = Modifier.height(15.dp))

        //second image
        Box(
            modifier = modifier
                .graphicsLayer {
                    //alpha = state.layoutInfo.normalizedItemPosition(news.id).absoluteValue
                }
                .fillMaxWidth()
                .height(250.dp)
                .padding(bottom = 16.dp, top = 16.dp)
                .background(color = Color.Transparent, shape = RoundedCornerShape(8.dp))
        ) {

            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp)),
                painter = painterResource(id = R.drawable.bg_1),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(15.dp))
        Text(
            modifier = Modifier.padding(horizontal = 4.dp),
            text = stringResource(id = R.string.lorem_ipsum_2),
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                lineHeight = 20.sp
            )
        )

        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 4.dp),
                text = "Is this really helpful?",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    lineHeight = 20.sp
                )
            )

            Row {
                IconWithText(
                    icon = Icons.Default.ThumbUp,
                    selectedIcon = Icons.Default.ThumbUp,
                    text = "381.4k"
                )

                IconWithText(
                    icon = Icons.Default.ThumbDown,
                    selectedIcon = Icons.Default.ThumbDown,
                    text = "18.4k"
                )
            }
        }

    }
}




@Preview(showBackground = true)
@Composable

fun PreviewNewsDetailScreen() {
    JetpackComposeUIChallengeTheme {
        NewsDetailsScreen() {

        }
    }
}