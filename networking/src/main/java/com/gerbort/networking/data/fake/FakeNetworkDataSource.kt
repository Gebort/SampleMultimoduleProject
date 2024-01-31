package com.gerbort.networking.data.fake

import com.gerbort.networking.domain.NetworkDataSource
import com.gerbort.networking.domain.model.UserInfoNetwork

class FakeNetworkDataSource: NetworkDataSource {
    override suspend fun getUserInfo(): UserInfoNetwork? {
        return UserInfoNetwork("Gerbort")
    }
}