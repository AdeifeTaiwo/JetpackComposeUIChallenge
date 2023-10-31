package com.example.jetpackcomposeuichallenge

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeuichallenge.authentication.do_you_know_screen.DoYouKnowScreen
import com.example.jetpackcomposeuichallenge.authentication.SignInScreen
import com.example.jetpackcomposeuichallenge.authentication.SignUpScreen
import com.example.jetpackcomposeuichallenge.authentication.account_setup.ChooseYourTopicScreen
import com.example.jetpackcomposeuichallenge.authentication.account_setup.SelectCountryScreen
import com.example.jetpackcomposeuichallenge.utility.NewsRoute
import com.example.jetpackcomposeuichallenge.utility.navigateSingleTopNoPopUpToHome
import com.example.jetpackcomposeuichallenge.utility.navigateSingleTopTo
import com.example.jetpackcomposeuichallenge.presentation.onBoarding.OnBoardingScreen

@Composable
fun NewsOnboardingApp(modifier: Modifier = Modifier) {

    Column(modifier = modifier.fillMaxSize()) {
        val navController = rememberNavController()

        OnboardingNavHost(
            navController = navController,
            modifier = modifier
                .padding(0.dp)
                .weight(1f),
        )

    }
}

@Composable
fun OnboardingNavHost(
    navController: NavHostController,
    modifier: Modifier,
    context: Context = LocalContext.current
) {
    NavHost(
        navController = navController,
        startDestination = NewsRoute.ONBOARDING,
        modifier = modifier
    ) {
        composable(route = NewsRoute.ONBOARDING) {

            OnBoardingScreen() {

                navController.navigateSingleTopTo(NewsRoute.DO_YOU_KNOW_SCREEN)

            }

        }

        composable(route = NewsRoute.DO_YOU_KNOW_SCREEN) {
            DoYouKnowScreen() {
                navController.navigateSingleTopNoPopUpToHome(NewsRoute.SIGN_IN_SCREEN)
            }
        }


        composable(route = NewsRoute.SIGN_UP_SCREEN) {

            SignUpScreen(
                onSignInButtonTextClicked = { navController.navigateSingleTopNoPopUpToHome(NewsRoute.SIGN_IN_SCREEN) }
            ) {
                navController.navigateSingleTopNoPopUpToHome(NewsRoute.SELECT_YOUR_COUNTRY_SCREEN)
            }
        }

        composable(route = NewsRoute.SIGN_IN_SCREEN) {
            SignInScreen(
                onSignUpTextClicked = { navController.navigateSingleTopNoPopUpToHome(NewsRoute.SIGN_UP_SCREEN) },
                onForgotPasswordTextClicked = {}
            ) {
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
            }
        }


        composable(route = NewsRoute.SELECT_YOUR_COUNTRY_SCREEN) {
            SelectCountryScreen(){
                navController.navigateSingleTopNoPopUpToHome(NewsRoute.SELECT_YOUR_TOPICS_SCREEN)
            }
        }


        composable(route = NewsRoute.SELECT_YOUR_TOPICS_SCREEN) {
            ChooseYourTopicScreen()
        }


    }


}