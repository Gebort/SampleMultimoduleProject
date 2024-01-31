package com.gerbort.preferences.domain.di

import android.content.Context
import com.gerbort.common.di.AppDispatchers
import com.gerbort.common.di.ApplicationScope
import com.gerbort.common.di.Dispatcher
import com.gerbort.preferences.data.PreferencesImpl
import com.gerbort.preferences.domain.Preferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object PreferencesModule {

    @Provides
    @Singleton
    internal fun providesUserPreferencesDataStore(
        @ApplicationContext context: Context,
        @Dispatcher(AppDispatchers.IO) ioDispatcher: CoroutineDispatcher,
        @ApplicationScope scope: CoroutineScope,
    ): Preferences {
        return PreferencesImpl(context, ioDispatcher, scope)
    }
}