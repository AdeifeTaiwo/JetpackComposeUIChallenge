package com.example.jetpackcomposeuichallenge.authentication


import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.compose.faintRed
import com.example.compose.lightRed
import com.example.compose.transparentGrey
import com.example.jetpackcomposeuichallenge.R
import com.example.jetpackcomposeuichallenge.presentation.components.ContinueButtonComponent
import com.example.jetpackcomposeuichallenge.presentation.components.SignInLogoWithText
import kotlinx.coroutines.launch

@OptIn(
    ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class,
    ExperimentalFoundationApi::class
)
@Composable

fun SignInScreen(
    modifier: Modifier = Modifier,
    onSignUpTextClicked: () -> Unit,
    onForgotPasswordTextClicked: () -> Unit,
    onSignInButtonClicked: () -> Unit
) {
    var emailText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    var isValidEmailAddress by remember { mutableStateOf(false) }
    var shouldRememberMe by remember { mutableStateOf(false) }



    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .fillMaxHeight()
            .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val bringIntoViewRequester = remember { BringIntoViewRequester() }
        val coroutineScope = rememberCoroutineScope()
        val focusManager = LocalFocusManager.current

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = modifier.size(200.dp),
                painter = painterResource(id = R.drawable.splash),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Let's Sign You In",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )
        }
        Spacer(modifier = Modifier.height(20.dp))


        ConstraintLayout(modifier = modifier) {
            val (rememberMeCheckBox, rememberMeText,
                asterik1, asterik2,
                emailLabel, passwordLabel,
                signUpButton, emailTextField,
                validEmailBox,
                passwordTextField) = createRefs()



            Text(
                modifier = modifier
                    .padding(top = 16.dp, bottom = 4.dp, start = 16.dp)
                    .constrainAs(emailLabel) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    },
                text = "Email",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )
            //asterik1
            Text(
                modifier = modifier
                    .padding(top = 16.dp)
                    .constrainAs(asterik1) {
                        top.linkTo(emailLabel.top)
                        start.linkTo(emailLabel.end)
                    },
                text = "*",
                style = TextStyle(
                    color = faintRed,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )

            OutlinedTextField(

                textStyle = TextStyle(fontSize = 14.sp),
                value = emailText,
                onValueChange = {
                    emailText = it.trim()
                    isValidEmailAddress = (it.length > 2
                            && android.util.Patterns.EMAIL_ADDRESS.matcher(it.trim()).matches())
                },
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
                    .constrainAs(emailTextField) {
                        top.linkTo(emailLabel.bottom)
                        start.linkTo(parent.start)
                    }
                    .bringIntoViewRequester(bringIntoViewRequester)
                    .onFocusEvent { focusState ->
                        if (focusState.isFocused) {
                            coroutineScope.launch {
                                bringIntoViewRequester.bringIntoView()
                            }
                        }
                    },
                maxLines = 1,
                placeholder = { Text(text = "Email", style = TextStyle(fontSize = 14.sp)) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.Transparent,
                    focusedBorderColor = faintRed,
                    unfocusedBorderColor = transparentGrey
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                ),
                shape = CircleShape,
            )

            //Invalid email address warning
            if (!isValidEmailAddress && emailText.length > 2) {
                Row(

                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(
                            color = lightRed,
                            shape = RoundedCornerShape(32.dp)
                        )
                        .fillMaxWidth()
                        .height(24.dp)
                        .padding(vertical = 4.dp)
                        .constrainAs(validEmailBox) {
                            top.linkTo(emailTextField.bottom)
                            start.linkTo(parent.start)

                        }
                ) {
                    Text(
                        modifier = modifier
                            .padding(start = 32.dp),
                        text = "Invalid email",
                        style = TextStyle(
                            color = faintRed,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    )

                }
            }

            Text(
                modifier = modifier
                    .padding(top = 32.dp, bottom = 4.dp, start = 16.dp)
                    .constrainAs(passwordLabel) {
                        top.linkTo(emailTextField.bottom)
                        start.linkTo(parent.start)
                    },
                text = "Password",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )
            //asterik2
            Text(
                modifier = modifier
                    .padding(top = 32.dp)
                    .constrainAs(asterik2) {
                        top.linkTo(passwordLabel.top)
                        start.linkTo(passwordLabel.end)
                    },
                text = "*",
                style = TextStyle(
                    color = faintRed,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )

            //password textfield
            OutlinedTextField(
                textStyle = TextStyle(fontSize = 14.sp),
                value = passwordText,
                onValueChange = { passwordText = it.trim() },
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .constrainAs(passwordTextField) {
                        top.linkTo(passwordLabel.bottom)
                        start.linkTo(parent.start)
                    }
                    .bringIntoViewRequester(bringIntoViewRequester)
                    .onFocusEvent { focusState ->
                        if (focusState.isFocused) {
                            coroutineScope.launch {
                                bringIntoViewRequester.bringIntoView()
                            }
                        }
                    },
                maxLines = 1,
                placeholder = { Text(text = "Password", style = TextStyle(fontSize = 14.sp)) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.Transparent,
                    focusedBorderColor = faintRed,
                    unfocusedBorderColor = transparentGrey
                ),
                shape = CircleShape,
                trailingIcon = {
                    val trailingIcon =
                        if (showPassword) Icons.Default.Visibility else Icons.Default.VisibilityOff

                    Icon(
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .clickable {
                                showPassword = !showPassword
                            },
                        imageVector = trailingIcon, contentDescription = "Search button"
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {

                    }
                ),
                visualTransformation = if (showPassword) {
                    VisualTransformation.None

                } else {
                    PasswordVisualTransformation()

                }
            )

            //checkbox row
            Checkbox(
                checked = shouldRememberMe,
                onCheckedChange = {
                    shouldRememberMe = it
                },
                modifier = modifier
                    .constrainAs(rememberMeCheckBox) {
                        top.linkTo(passwordTextField.bottom)
                        start.linkTo(parent.start)
                    }
                    .padding(start = 8.dp, top = 16.dp, end = 4.dp)
                    .clip(RoundedCornerShape(4.dp)),
                colors = CheckboxDefaults.colors(
                    checkedColor = faintRed,
                    checkmarkColor = Color.White,
                    disabledCheckedColor = transparentGrey
                )
            )

            //rem text
            Text(
                modifier = modifier
                    .padding(top = 16.dp)
                    .constrainAs(rememberMeText) {
                        top.linkTo(rememberMeCheckBox.top)
                        start.linkTo(rememberMeCheckBox.end)
                        bottom.linkTo(rememberMeCheckBox.bottom)
                    },
                text = "Remember Me",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )
            //SignIn button
            ContinueButtonComponent(
                modifier = modifier
                    .constrainAs(
                        signUpButton
                    ) {
                        top.linkTo(rememberMeCheckBox.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                enabled = isValidEmailAddress,
                buttonText = "Sign In"
            ) {
                onSignInButtonClicked()
            }
        }


        Spacer(modifier = Modifier.height(40.dp))

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                modifier = modifier.clickable {
                    onForgotPasswordTextClicked()
                },
                text = "Forgot the password?",
                style = TextStyle(
                    color = faintRed,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                modifier = modifier,
                text = "or continue with",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                SignInLogoWithText(
                    modifier = Modifier.weight(1f),
                    logo = R.drawable.facebook_logo,
                    logoName = "Facebook"
                )
                SignInLogoWithText(
                    modifier = Modifier.weight(1f),
                    logo = R.drawable.google_logo,
                    logoName = "Google"
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

        }

        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = modifier,
                text = "Don't have an account?",
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                modifier = modifier.clickable {
                    onSignUpTextClicked()
                },
                text = "Sign up",
                style = TextStyle(
                    color = faintRed,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

    }


}