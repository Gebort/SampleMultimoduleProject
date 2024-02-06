package com.gerbort.invmanager

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.gerbort.common.logging.log
import com.gerbort.invmanager.ui.AppScaffold
import com.gerbort.login.presentation.NavGraphs
import com.gerbort.login.presentation.destinations.Destination
import com.gerbort.login.presentation.destinations.LoginRouteDestination
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.defaults.RootNavGraphDefaultAnimations
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine

@OptIn(ExperimentalMaterialNavigationApi::class, ExperimentalAnimationApi::class)
@Composable
fun AppContent() {
    val engine = rememberAnimatedNavHostEngine(
        rootDefaultAnimations = RootNavGraphDefaultAnimations.ACCOMPANIST_FADING,
        defaultAnimationsForNestedNavGraph = mapOf(
//                    NavGraphs.settings to NestedNavGraphDefaultAnimations(
//                        enterTransition = { fadeIn(animationSpec = tween(2000)) },
//                        exitTransition = { fadeOut(animationSpec = tween(2000)) }
//                    ),
//                    NavGraphs.other to NestedNavGraphDefaultAnimations.ACCOMPANIST_FADING
        )

    )
    val navController = engine.rememberNavController()

    navController.addOnDestinationChangedListener { _, destination, _ ->
        destination.log("Navigating to ${destination.route}")
    }

    val startRoute = LoginRouteDestination

    AppScaffold(
        navController = navController,
        startRoute = startRoute,
        topBar = { dest, backStackEntry ->
            if (dest.shouldShowScaffoldElements) {
                //TopBar(dest, backStackEntry)
            }
        },
        bottomBar = {
            if (it.shouldShowScaffoldElements) {
                //BottomBar(navController)
            }
        }
    ) {
        DestinationsNavHost(
            engine = engine,
            navController = navController,
            navGraph = NavGraphs.root,
            //modifier = Modifier.padding(it).fillMaxSize(),
            startRoute = startRoute
        )
    }
}

private val Destination.shouldShowScaffoldElements get() = true