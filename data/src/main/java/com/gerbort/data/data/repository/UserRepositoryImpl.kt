package com.gerbort.data.data.repository

import com.gerbort.common.model.User
import com.gerbort.data.data.model.toCommon
import com.gerbort.data.domain.Synchronizer
import com.gerbort.data.domain.repository.UserRepository
import com.gerbort.database.dao.UserDao
import com.gerbort.networking.domain.NetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepositoryImpl(
    private val userDataSource: NetworkDataSource,
    private val userDao: UserDao
): UserRepository {
    override fun getUser(): Flow<User?> {
        return userDao.getUserInfo()
            .map { it.firstOrNull()?.toCommon() }
    }

    override suspend fun saveUser(user: User) {
        //TODO
    }

    override suspend fun syncWith(synchronizer: Synchronizer): Boolean {
        TODO("Not yet implemented")
    }
}