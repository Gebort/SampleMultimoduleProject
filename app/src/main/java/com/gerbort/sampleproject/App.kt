package com.gerbort.sampleproject

import android.app.Application
import com.gerbort.data.domain.SyncManager
import com.gerbort.sampleproject.logging.LoggingHandler
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

/**
 * [Application] class for the app
 */
@HiltAndroidApp
class App: Application() {

    @Inject
    lateinit var syncManager: SyncManager

    override fun onCreate() {
        super.onCreate()

        LoggingHandler.setup()
        syncManager.requestSync()

    }

}