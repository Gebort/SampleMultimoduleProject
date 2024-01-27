package com.gerbort.networking.domain.di

import com.gerbort.networking.data.NetworkMonitorImpl
import com.gerbort.networking.domain.NetworkMonitor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkingModule {

    @Provides
    @Singleton
    internal fun provideNetworkMonitor(): NetworkMonitor {
        return NetworkMonitorImpl()
    }

}