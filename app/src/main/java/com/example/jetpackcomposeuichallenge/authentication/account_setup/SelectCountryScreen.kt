package com.example.jetpackcomposeuichallenge.authentication.account_setup

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.compose.faintRed
import com.example.compose.transparentGrey
import com.example.jetpackcomposeuichallenge.components.AppSearchBar
import com.example.jetpackcomposeuichallenge.components.BackButtonWithMenuIcon
import com.example.jetpackcomposeuichallenge.components.ContinueButtonComponent
import com.example.jetpackcomposeuichallenge.data.local.CountryProvider
import com.example.jetpackcomposeuichallenge.items.CountryItem

@Composable
fun SelectCountryScreen(
    modifier: Modifier = Modifier,
    onContinueButtonClicked: () -> Unit
) {
    val items = CountryProvider.getCountryList()
    var selectedItemIndex by remember { mutableStateOf(-1) }

    Column {


        LazyColumn(
            horizontalAlignment = Alignment.Start,
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(1.0f)
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .border(width = 1.dp, color = transparentGrey)
                .padding(4.dp)

        ) {

            item {
                Spacer(modifier = Modifier.height(10.dp))

                BackButtonWithMenuIcon(headerText = "Select YOur Country")

                Spacer(modifier = Modifier.height(20.dp))

                AppSearchBar()


                items.forEachIndexed { index, item ->

                    CountryItem(
                        item = item,
                        isSelected = (index == selectedItemIndex),
                        activeHighlightColor = faintRed,
                        activeTextColor = faintRed,
                        inActiveTextColor = faintRed,
                        onItemClick = {
                            selectedItemIndex = if (selectedItemIndex != index) {
                                index
                            } else -1
                        }

                    )
                }
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
                onContinueButtonClicked()
            }
        }


    }
}