package com.gerbort.sampleproject.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.gerbort.login.presentation.navigation.LOGIN_ROUTE
import com.gerbort.login.presentation.navigation.loginScreen
import com.gerbort.login.presentation.navigation.logout
import com.gerbort.login.presentation.navigation.navigateToSecondScreen
import com.gerbort.login.presentation.navigation.secondScreen

/**
 * Top-level navigation graph.
 *
 * The navigation graph defined in this file defines the different top level routes.
 */
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    startDestination: String = LOGIN_ROUTE,
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        loginScreen(onNextScreen = navController::navigateToSecondScreen)
        secondScreen(onBack = navController::navigateUp)
    }
}