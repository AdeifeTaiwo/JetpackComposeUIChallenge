package com.example.jetpackcomposeuichallenge.authentication.account_setup

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeuichallenge.ui.theme.transparentGrey
import com.example.jetpackcomposeuichallenge.presentation.components.AppSearchBar
import com.example.jetpackcomposeuichallenge.presentation.components.BackButtonWithMenuIcon
import com.example.jetpackcomposeuichallenge.presentation.components.ContinueButtonComponent
import com.example.jetpackcomposeuichallenge.data.local.NewsTopicsProvider
import com.example.jetpackcomposeuichallenge.presentation.list_items.ChooseYourTopicsItem
import com.example.jetpackcomposeuichallenge.ui.theme.JetpackComposeUIChallengeTheme

@Composable
fun ChooseYourTopicScreen(modifier: Modifier= Modifier){
    val items = NewsTopicsProvider.getAllTopics
    var selectedItemIndex by remember { mutableStateOf(-1) }


    Column {


        Spacer(modifier = Modifier.height(10.dp))

        BackButtonWithMenuIcon(headerText = "Select YOur Country")

        Spacer(modifier = Modifier.height(20.dp))

        AppSearchBar(text = "",
            onValueChange = {},
            onSearch = {})

        Spacer(modifier = Modifier.height(20.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(1.0f)
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .border(width = 1.dp, color = transparentGrey)
                .padding(4.dp),
            contentPadding = PaddingValues(vertical = 10.dp, horizontal = 4.dp)

        ) {

            items(items.size){index ->
                ChooseYourTopicsItem(
                    item = NewsTopicsProvider.getAllTopics[index],
                    isSelected = (index == selectedItemIndex),
                    onItemClick = {
                        selectedItemIndex = index
                    }

                )

            }



        }




        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .height(70.dp)
                .fillMaxWidth()
                .background(
                    color = Color.Transparent
                )
                .border(
                    1.dp,
                    color = transparentGrey,
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                )
                .clickable {},
            contentAlignment = Alignment.Center
        )
        {
            ContinueButtonComponent(buttonText = "Next", enabled = selectedItemIndex != -1) {

            }
        }


    }
}


@Preview(showBackground = true)
@Composable
fun PreviewChooseTopicScreen(){
    JetpackComposeUIChallengeTheme {
        ChooseYourTopicScreen()
    }
}