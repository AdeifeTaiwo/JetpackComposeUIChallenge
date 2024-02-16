package com.example.jetpackcomposeuichallenge.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeuichallenge.ui.theme.transparentGrey
import com.example.jetpackcomposeuichallenge.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppSearchBar(
    modifier: Modifier = Modifier,
    text: String,
    onSearch: () -> Unit,
    onValueChange: (String) -> Unit,
) {
    var searchText by remember { mutableStateOf("") }

    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .height(46.dp)
                .background(
                    transparentGrey,
                    CircleShape
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                textStyle = TextStyle(fontSize = 14.sp),
                value = text,
                onValueChange = { onValueChange(it) },
                modifier = Modifier.fillMaxHeight(),
                maxLines = 1,
                placeholder = {
                    Text(
                        text = "search here...",
                        style = TextStyle(fontSize = 14.sp)
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                trailingIcon = {
                    Icon(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .clickable {

                            },
                        imageVector = Icons.Default.Search, contentDescription = "Search button"
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onDone = {

                    },
                    onSearch = {
                        onSearch()
                    }
                ),
            )
        }

        Spacer(modifier = Modifier.width(16.dp))
        ThreeLinesIcon()
    }

}