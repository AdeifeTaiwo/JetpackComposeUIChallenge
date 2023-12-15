package com.example.jetpackcomposeuichallenge.presentation.home.profileedit

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ProfileEditScreen(
    viewModel: ProfileEditViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 14.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val uiState = viewModel.uiState.value

        Column {
            Icon(
                modifier = Modifier.padding(start = 16.dp),
                imageVector = Icons.Default.Close, contentDescription = ""
            )

            Spacer(modifier = Modifier.height(16.dp))
            ProfileDetailsEditComponent(
                text = uiState.firstName,
                title = "First Name",
                placeHolder = "Gary"
            ) {
                viewModel.onEvent(ProfileEditEvent.EditFirstName(it))
            }

            ProfileDetailsEditComponent(
                text = uiState.lastName,
                title = "Last Name",
                shouldShowStraightLine = false,
                placeHolder = "Rudolph"
            ) {
                viewModel.onEvent(ProfileEditEvent.EditLastName(it))
            }

            ProfileDetailsEditComponent(
                text = uiState.email,
                title = "Email",
                shouldShowStraightLine = false,
                placeHolder = "lolay@gmail.com"
            ) {
                viewModel.onEvent(ProfileEditEvent.EditEmail(it))
            }

            ProfileDetailsEditComponent(
                text = uiState.mobileNumber,
                title = "Mobile Phone",
                placeHolder = "082827728382"
            )
            {
                viewModel.onEvent(ProfileEditEvent.EditMobileNumber(it))
            }

        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0XFF098EEF)
            ),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth(0.7f),
            onClick = {},
        ) {
            Text(text = "Save")
        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileDetailsEditComponent(
    text: String,
    title: String,
    shouldShowStraightLine: Boolean = true,
    placeHolder: String = "",
    onValueChange: (String) -> Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        OutlinedTextField(
            value = text,
            onValueChange = { onValueChange(it) },
            placeholder = { Text(text = placeHolder) },

            modifier = Modifier.padding(start = 0.dp).fillMaxWidth(),


            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color.Transparent,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.Black
            ),
            label = { Text(text = title) },
            trailingIcon = {
                Icon(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .clickable {},
                    imageVector = Icons.Default.Cancel,
                    contentDescription = "",
                    tint = Color.LightGray
                )
            }
        )
    }

    Spacer(modifier = Modifier.height(16.dp))
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileEditScreen() {
    ProfileEditScreen()
}