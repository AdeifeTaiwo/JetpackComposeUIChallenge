package com.example.jetpackcomposeuichallenge.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.compose.faintRed
import com.example.compose.transparentGrey
import com.example.jetpackcomposeuichallenge.data.Topics


@Composable
fun ChooseYourTopicsItem(
    modifier: Modifier = Modifier,
    item: Topics,
    isSelected: Boolean = false,
    onItemClick: () -> Unit

) {

    var isTopicSelected by remember { mutableStateOf(false) }


    Box(
        modifier = Modifier

            .clip(RoundedCornerShape(8.dp))
            .width(240.dp)
            .height(160.dp)
            .padding(horizontal = 8.dp, vertical = 8.dp)

            .border(
                4.dp,
                color = if (isTopicSelected) faintRed else transparentGrey,
                shape = RoundedCornerShape( 16.dp)
            )
            .background(
                color = Color.Transparent
            )
            .clickable {},
        contentAlignment = Alignment.Center
    ) {
        ConstraintLayout(
            modifier = modifier
                .fillMaxSize()
        ) {
            val (selectedTopicsCheckBox, topic, image) = createRefs()



            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .constrainAs(image) {}
                    .clip(RoundedCornerShape(16.dp)),
                painter = painterResource(id = item.image),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )


            Text(
                modifier = modifier
                    .constrainAs(topic) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    }
                    .padding(start = 8.dp, bottom = 16.dp, top = 16.dp, end = 4.dp),
                text = item.topic,
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 18.sp
                )
            )

            //checkbox row
            Checkbox(
                checked = isTopicSelected,
                onCheckedChange = {
                    isTopicSelected = it
                },
                modifier = modifier
                    .constrainAs(selectedTopicsCheckBox) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    }
                    .padding(start = 8.dp, bottom = 16.dp, top = 8.dp, end = 8.dp)
                    .clip(RoundedCornerShape(4.dp)),
                colors = CheckboxDefaults.colors(
                    checkedColor = faintRed,
                    checkmarkColor = Color.White,
                    disabledCheckedColor = faintRed,
                    disabledUncheckedColor = Color.White
                )
            )
        }
    }

}