package com.gerbort.login.presentation.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.gerbort.login.presentation.LoginRoute

const val LOGOUT = "logout"
const val LOGIN_ROUTE_LABEL = "login_route"
const val LOGIN_ROUTE = "$LOGIN_ROUTE_LABEL?$LOGOUT={$LOGOUT}"
private const val DEEP_LINK_URI_PATTERN =
    "https://www.nowinandroid.apps.samples.google.com/$LOGIN_ROUTE_LABEL/$LOGOUT"

fun NavController.logout() = navigate("$LOGIN_ROUTE_LABEL?${LOGOUT}=${true}") {
    launchSingleTop = true
    popBackStack()
}
fun NavController.navigateToLogin() = navigate("$LOGIN_ROUTE_LABEL?${LOGOUT}=${false}") {
    launchSingleTop = true
}

fun NavGraphBuilder.loginScreen(onNextScreen: () -> Unit) {
    composable(
        route = LOGIN_ROUTE,
        deepLinks = listOf(
            navDeepLink { uriPattern = DEEP_LINK_URI_PATTERN },
        ),
        arguments = listOf(
            navArgument(LOGOUT) {
                type = NavType.BoolType
                defaultValue = false
            },
        ),
        enterTransition = { slideInHorizontally() },
        exitTransition = { slideOutHorizontally() }
    ) {backStackEntry ->
        LoginRoute(
            onSecondScreen = onNextScreen,
            logout = backStackEntry.arguments?.getBoolean(LOGOUT) ?: false
        )
    }
}