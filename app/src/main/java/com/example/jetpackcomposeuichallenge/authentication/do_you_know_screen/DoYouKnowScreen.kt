package com.example.jetpackcomposeuichallenge.authentication.do_you_know_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.SpaceDashboard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.JetpackComposeUIChallengeTheme
import com.example.jetpackcomposeuichallenge.presentation.components.BackButtonWithMenuIcon
import com.example.jetpackcomposeuichallenge.presentation.components.ContinueButtonComponent
import com.example.jetpackcomposeuichallenge.presentation.components.SelectRolesBoxComponent

@Composable
fun DoYouKnowScreen(
    onContinueButtonClick: () -> Unit
) {

    Column(modifier = Modifier.padding(10.dp)) {

        val selectedRoles = remember { mutableStateOf(Roles.NIL) }

        Spacer(modifier = Modifier.height(10.dp))

        BackButtonWithMenuIcon(headerText = "Do You?")

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            modifier = Modifier.padding(10.dp),
            text = "Choose the role that best describes you now, whether you're a news agency or personal",
            style = TextStyle(
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        SelectRolesBoxComponent(
            title = "News Agency",
            descText = "You will need further verification if your are a news agency company",
            selectedRoles = selectedRoles.value,
            roles = Roles.NEWS_AGENCY,
            imageVector = Icons.Default.SpaceDashboard,
        ) {
            selectedRoles.value = Roles.NEWS_AGENCY
        }

        Spacer(modifier = Modifier.height(10.dp))

        SelectRolesBoxComponent(
            title = "Personal",
            descText = "Suitable for those who use this application to read news (But you can still make your own news )",
            selectedRoles = selectedRoles.value,
            roles = Roles.PERSONAL,
            imageVector = Icons.Default.Person,
        ) {
            selectedRoles.value = Roles.PERSONAL
        }
        val screenHeight = LocalConfiguration.current.screenHeightDp

        Spacer(modifier = Modifier.height(300.dp))

        ContinueButtonComponent(
            enabled = selectedRoles.value != Roles.NIL,
            modifier = Modifier.fillMaxWidth()
        ) {
            onContinueButtonClick()
        }


    }
}

enum class Roles {
    PERSONAL,
    NEWS_AGENCY,
    NIL
}


@Composable
fun PreviewDoYouKnowScreen() {
    JetpackComposeUIChallengeTheme {
        DoYouKnowScreen(){}
    }
}