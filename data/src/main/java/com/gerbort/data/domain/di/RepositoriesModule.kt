package com.gerbort.data.domain.di

import com.gerbort.data.data.repository.UserRepositoryImpl
import com.gerbort.data.domain.repository.UserRepository
import com.gerbort.database.dao.UserDao
import com.gerbort.networking.domain.NetworkDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RepositoriesModule {

    @Provides
    @Singleton
    fun provideUserRepository(
        userDao: UserDao,
        userDataSource: NetworkDataSource
    ): UserRepository {
        return UserRepositoryImpl(userDataSource, userDao)
    }

}