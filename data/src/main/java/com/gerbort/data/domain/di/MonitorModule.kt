package com.gerbort.data.domain.di

import android.content.Context
import com.gerbort.data.data.NetworkMonitorImpl
import com.gerbort.data.domain.NetworkMonitor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MonitorModule {

    @Provides
    @Singleton
    internal fun provideNetworkMonitor(
        @ApplicationContext context: Context
    ): NetworkMonitor {
        return NetworkMonitorImpl(context)
    }

}