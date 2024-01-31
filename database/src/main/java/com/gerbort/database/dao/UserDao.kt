package com.gerbort.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.gerbort.database.model.UserInfoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM UserInfoEntity")
    fun getUserInfo(): Flow<List<UserInfoEntity>>

}