package com.gerbort.data.domain.repository

import com.gerbort.common.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUser(): Flow<User?>

    suspend fun saveUser(user: User)

}