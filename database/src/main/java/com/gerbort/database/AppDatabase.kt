package com.gerbort.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.gerbort.database.dao.UserDao
import com.gerbort.database.model.UserInfoEntity
import com.gerbort.database.util.InstantConverter

@Database(
    entities = [
        UserInfoEntity::class
    ],
    version = 1,
    exportSchema = true,
    autoMigrations = [

    ]
)
@TypeConverters(
    InstantConverter::class,
)
internal abstract class AppDatabase: RoomDatabase() {

    abstract val userDao: UserDao

}