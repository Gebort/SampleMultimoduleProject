package com.gerbort.login.presentation.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.gerbort.login.presentation.SecondRoute

const val SECOND_SCREEN_LABEL = "second_screen"
const val SECOND_SCREEN_ROUTE = SECOND_SCREEN_LABEL
private const val DEEP_LINK_URI_PATTERN =
    "https://www.nowinandroid.apps.samples.google.com/$SECOND_SCREEN_LABEL"

fun NavController.navigateToSecondScreen() = navigate(SECOND_SCREEN_LABEL) {
    launchSingleTop = true
    popBackStack()
}

fun NavGraphBuilder.secondScreen(onBack: () -> Unit) {
    composable(
        route = SECOND_SCREEN_ROUTE,
        deepLinks = listOf(
            navDeepLink { uriPattern = DEEP_LINK_URI_PATTERN },
        ),
        enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
        exitTransition = { slideOutHorizontally(targetOffsetX = { it }) }
    ) {
        SecondRoute(onBack = onBack)
    }
}