package com.gerbort.invmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.core.core_ui.theme.InvManagerTheme
import com.gerbort.login.presentation.NavGraphs
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InvManagerTheme {
                DestinationsNavHost(
                    navGraph = NavGraphs.root,
                )
            }
        }
    }
}