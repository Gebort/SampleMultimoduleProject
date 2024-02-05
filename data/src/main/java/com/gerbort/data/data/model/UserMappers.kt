package com.gerbort.data.data.model

import com.gerbort.common.model.User
import com.gerbort.database.model.UserInfoEntity
import com.gerbort.networking.domain.model.UserInfoNetwork

internal fun User.toEntity(): UserInfoEntity {
    return UserInfoEntity(
        id = id,
        name = name,
    )
}

internal fun UserInfoEntity.toCommon(): User {
    return User(
        id = id!!,
        name = name,
    )
}

internal fun UserInfoEntity.toNetwork(): UserInfoNetwork {
    return UserInfoNetwork(
        name = name,
    )
}