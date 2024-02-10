package com.gerbort.sampleproject

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.gerbort.common.logging.log
import com.gerbort.sampleproject.navigation.AppNavHost

@Composable
fun AppContent() {
    val navController = rememberNavController()

    navController.addOnDestinationChangedListener { _, destination, _ ->
        destination.log("Navigating to ${destination.route}")
    }

    Scaffold(
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets(0, 128, 0, 64),
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            AppNavHost(
                navController = navController
            )
        }
    }
}