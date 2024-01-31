package com.gerbort.networking.domain

import com.gerbort.networking.domain.model.UserInfoNetwork

interface NetworkDataSource {

    suspend fun getUserInfo(): UserInfoNetwork?

}
