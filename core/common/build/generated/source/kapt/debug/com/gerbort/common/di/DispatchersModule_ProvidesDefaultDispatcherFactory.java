// Generated by Dagger (https://dagger.dev).
package com.gerbort.common.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import kotlinx.coroutines.CoroutineDispatcher;

@ScopeMetadata
@QualifierMetadata("com.gerbort.common.di.Dispatcher")
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class DispatchersModule_ProvidesDefaultDispatcherFactory implements Factory<CoroutineDispatcher> {
  @Override
  public CoroutineDispatcher get() {
    return providesDefaultDispatcher();
  }

  public static DispatchersModule_ProvidesDefaultDispatcherFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CoroutineDispatcher providesDefaultDispatcher() {
    return Preconditions.checkNotNullFromProvides(DispatchersModule.INSTANCE.providesDefaultDispatcher());
  }

  private static final class InstanceHolder {
    private static final DispatchersModule_ProvidesDefaultDispatcherFactory INSTANCE = new DispatchersModule_ProvidesDefaultDispatcherFactory();
  }
}