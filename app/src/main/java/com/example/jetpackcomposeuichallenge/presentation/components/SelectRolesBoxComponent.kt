package com.example.jetpackcomposeuichallenge.presentation.components

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SpaceDashboard
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.faintRed
import com.example.compose.transparentGrey
import com.example.jetpackcomposeuichallenge.authentication.do_you_know_screen.Roles


@Composable
fun SelectRolesBoxComponent(
    title: String,
    descText: String,
    selectedRoles: Roles,
    roles: Roles,
    imageVector: ImageVector,
    onItemClick: (Roles) -> Unit
) {

    Card(
        modifier = Modifier
            .graphicsLayer {}
            .height(160.dp)
            .fillMaxWidth()
            .background(color = Color.Transparent)
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .semantics { },
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        border = BorderStroke(
            1.dp,
            color = if (selectedRoles.name == roles.name) faintRed else transparentGrey
        ),

        elevation = CardDefaults.outlinedCardElevation(
            pressedElevation = 0.dp
        )

    ) {

        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxHeight()
                .clickable { onItemClick(roles) }
                .weight(1.0f),
            verticalAlignment = Alignment.CenterVertically
        ) {

            CircularIconWithLightRedBg(imageVector = imageVector)

            Spacer(modifier = Modifier.width(10.dp))

            Column(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 32.dp)
                    .fillMaxHeight()
                    .weight(.7f),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 18.sp
                    )
                )
                Text(
                    text = descText,
                    style = TextStyle(
                        color = Color.Gray,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    ),
                    maxLines = 2
                )
            }
        }
    }
}