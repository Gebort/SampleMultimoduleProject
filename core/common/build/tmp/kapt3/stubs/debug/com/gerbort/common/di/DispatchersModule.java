package com.gerbort.common.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\u0006"}, d2 = {"Lcom/gerbort/common/di/DispatchersModule;", "", "()V", "providesDefaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "providesIODispatcher", "common_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class DispatchersModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.gerbort.common.di.DispatchersModule INSTANCE = null;
    
    private DispatchersModule() {
        super();
    }
    
    @dagger.Provides()
    @Dispatcher(dispatcher = com.gerbort.common.di.AppDispatchers.IO)
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.CoroutineDispatcher providesIODispatcher() {
        return null;
    }
    
    @dagger.Provides()
    @Dispatcher(dispatcher = com.gerbort.common.di.AppDispatchers.Default)
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.CoroutineDispatcher providesDefaultDispatcher() {
        return null;
    }
}