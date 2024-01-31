package com.gerbort.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserInfoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
)
