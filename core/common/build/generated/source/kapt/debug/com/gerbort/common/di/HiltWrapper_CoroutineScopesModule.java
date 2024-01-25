package com.gerbort.common.di;

import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;

@OriginatingElement(
    topLevelClass = CoroutineScopesModule.class
)
@InstallIn(SingletonComponent.class)
@Module(
    includes = CoroutineScopesModule.class
)
public final class HiltWrapper_CoroutineScopesModule {
}
