package com.gerbort.sync.di

import android.content.Context
import com.gerbort.data.domain.SyncManager
import com.gerbort.sync.manager.WorkManagerSyncManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SyncModule {
    @Provides
    @Singleton
    internal fun provideSyncStatusMonitor(
        @ApplicationContext context: Context
    ): SyncManager {
       return WorkManagerSyncManager(context)
    }

}