package com.gerbort.database.di

import com.gerbort.database.AppDatabase
import com.gerbort.database.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DaosModule {

    @Provides
    fun provideUserDao(
        database: AppDatabase
    ): UserDao = database.userDao

}