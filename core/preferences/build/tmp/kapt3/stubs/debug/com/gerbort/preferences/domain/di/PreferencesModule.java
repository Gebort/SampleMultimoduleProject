package com.gerbort.preferences.domain.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u0001\u00a2\u0006\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/gerbort/preferences/domain/di/PreferencesModule;", "", "()V", "providesUserPreferencesDataStore", "Lcom/gerbort/preferences/domain/Preferences;", "context", "Landroid/content/Context;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "providesUserPreferencesDataStore$preferences_debug", "preferences_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class PreferencesModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.gerbort.preferences.domain.di.PreferencesModule INSTANCE = null;
    
    private PreferencesModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.gerbort.preferences.domain.Preferences providesUserPreferencesDataStore$preferences_debug(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @com.gerbort.common.di.Dispatcher(dispatcher = com.gerbort.common.di.AppDispatchers.IO)
    @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher ioDispatcher, @com.gerbort.common.di.ApplicationScope()
    @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope scope) {
        return null;
    }
}