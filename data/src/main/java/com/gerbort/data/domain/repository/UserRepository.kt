package com.gerbort.data.domain.repository

import com.gerbort.common.model.User
import com.gerbort.data.domain.Syncable
import kotlinx.coroutines.flow.Flow

interface UserRepository: Syncable {

    fun getUser(): Flow<User?>

    suspend fun saveUser(user: User)

}