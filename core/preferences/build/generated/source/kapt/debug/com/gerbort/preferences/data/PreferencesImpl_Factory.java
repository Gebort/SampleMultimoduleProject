// Generated by Dagger (https://dagger.dev).
package com.gerbort.preferences.data;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

@ScopeMetadata
@QualifierMetadata({
    "com.gerbort.common.di.ApplicationScope",
    "com.gerbort.common.di.Dispatcher"
})
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class PreferencesImpl_Factory implements Factory<PreferencesImpl> {
  private final Provider<Context> contextProvider;

  private final Provider<CoroutineDispatcher> dispatcherProvider;

  private final Provider<CoroutineScope> scopeProvider;

  public PreferencesImpl_Factory(Provider<Context> contextProvider,
      Provider<CoroutineDispatcher> dispatcherProvider, Provider<CoroutineScope> scopeProvider) {
    this.contextProvider = contextProvider;
    this.dispatcherProvider = dispatcherProvider;
    this.scopeProvider = scopeProvider;
  }

  @Override
  public PreferencesImpl get() {
    return newInstance(contextProvider.get(), dispatcherProvider.get(), scopeProvider.get());
  }

  public static PreferencesImpl_Factory create(Provider<Context> contextProvider,
      Provider<CoroutineDispatcher> dispatcherProvider, Provider<CoroutineScope> scopeProvider) {
    return new PreferencesImpl_Factory(contextProvider, dispatcherProvider, scopeProvider);
  }

  public static PreferencesImpl newInstance(Context context, CoroutineDispatcher dispatcher,
      CoroutineScope scope) {
    return new PreferencesImpl(context, dispatcher, scope);
  }
}
