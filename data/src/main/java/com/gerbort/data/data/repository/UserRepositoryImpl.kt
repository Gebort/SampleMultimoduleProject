package com.gerbort.data.data.repository

import com.gerbort.common.model.User
import com.gerbort.data.data.model.toCommon
import com.gerbort.data.domain.Synchronizer
import com.gerbort.data.domain.repository.UserRepository
import com.gerbort.database.dao.UserDao
import com.gerbort.networking.domain.NetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class UserRepositoryImpl(
    private val userNetworkDao: NetworkDataSource,
    private val userRoomDao: UserDao
): UserRepository {
    override fun getUser(): Flow<User?> {
        return userRoomDao.getUserInfo()
            .map { it.firstOrNull()?.toCommon() }
    }

    override suspend fun saveUser(user: User) {
        //TODO
    }

    override suspend fun syncWith(synchronizer: Synchronizer): Boolean {
        return true
    }
}