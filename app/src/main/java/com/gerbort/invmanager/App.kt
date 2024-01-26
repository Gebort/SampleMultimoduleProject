package com.gerbort.invmanager

import android.app.Application
import com.gerbort.invmanager.logging.LoggingHandler
import dagger.hilt.android.HiltAndroidApp

/**
 * [Application] class for the app
 */
@HiltAndroidApp
class App: Application() {

    override fun onCreate() {
        super.onCreate()

        LoggingHandler.setup()

    }

}