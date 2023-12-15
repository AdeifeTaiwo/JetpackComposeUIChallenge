package com.example.jetpackcomposeuichallenge.presentation.home.notificationedit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NotificationEditScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //val uiState = viewModel.uiState.value
        Column {
            Icon(
                modifier = Modifier.padding(start = 16.dp),
                imageVector = Icons.Default.Close, contentDescription = ""
            )

            Spacer(modifier = Modifier.height(32.dp))
            NotificationHeader(headerText = "Email")

            Spacer(modifier = Modifier.height(16.dp))

            val radioOptions = listOf(
                EMAILTYPE.INDIVIDUAL_EMAIL,
                EMAILTYPE.INVENTORY_EMAIL,
                EMAILTYPE.PAYMENT_COMPLETE_EMAIL,
                EMAILTYPE.DAILY_SUMMARY_EMAIL
            )

            var selectedEmailItem by remember {
                mutableStateOf(radioOptions[0])
            }

            Column(modifier = Modifier.selectableGroup()) {
                radioOptions.forEach { emailType ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(42.dp)
                            .selectable(
                                selected = (selectedEmailItem == emailType),
                                onClick = { selectedEmailItem = emailType },
                                role = Role.RadioButton
                            )
                            .padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            modifier = Modifier.padding(end = 8.dp),
                            selected = (selectedEmailItem == emailType),
                            onClick = null, // null recommended for accessibility with screen readers
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xFF0071C4)
                            )
                        )
                        Text(text = emailType.desc)
                    }
                }
            }

            //PushNotification

            Spacer(modifier = Modifier.height(32.dp))
            NotificationHeader(headerText = "Push")

            Spacer(modifier = Modifier.height(16.dp))

            val pushNotifRadioOptions = listOf(
                NOTIFICATIONTYPE.INDIVIDUAL_NOTIFICATION,
                NOTIFICATIONTYPE.INVENTORY_NOTIFICATION,
                NOTIFICATIONTYPE.PAYMENT_COMPLETE_NOTIFICATION,
                NOTIFICATIONTYPE.DAILY_SUMMARY_NOTIFICATION
            )

            var selectedNotificationItem by remember {
                mutableStateOf(pushNotifRadioOptions[0])
            }

            Column(modifier = Modifier.selectableGroup()) {
                pushNotifRadioOptions.forEach { notificationType ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(42.dp)
                            .selectable(
                                selected = (selectedNotificationItem == notificationType),
                                onClick = { selectedNotificationItem = notificationType },
                                role = Role.RadioButton
                            )
                            .padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            modifier = Modifier.padding(end = 8.dp),
                            selected = (selectedNotificationItem == notificationType),
                            onClick = null, // null recommended for accessibility with screen readers
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xFF0071C4)
                            )
                        )
                        Text(text = notificationType.desc)
                    }
                }
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

@Composable
fun NotificationHeader(headerText: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFF0071C4))
    ) {

        Text(
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 6.dp),
            text = headerText,
            style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.W400
            )
        )

    }
}

enum class EMAILTYPE(val desc: String){
    INDIVIDUAL_EMAIL("Receive Individual sale email"),
    INVENTORY_EMAIL("Receive new inventory email"),
    PAYMENT_COMPLETE_EMAIL("Receive payment complete email"),
    DAILY_SUMMARY_EMAIL("Receive daily summary email")

}

enum class NOTIFICATIONTYPE(val desc: String){
    INDIVIDUAL_NOTIFICATION("Receive Individual sale app notification"),
    INVENTORY_NOTIFICATION("Receive new inventory app notification"),
    PAYMENT_COMPLETE_NOTIFICATION("Receive payment complete app notification"),
    DAILY_SUMMARY_NOTIFICATION("Receive daily summary app notification")
}


@Preview(showBackground = true)
@Composable
fun PreviewNotificationEditScreen() {
    NotificationEditScreen()
}