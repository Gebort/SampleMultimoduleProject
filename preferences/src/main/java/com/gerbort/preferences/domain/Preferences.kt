package com.gerbort.preferences.domain

import kotlinx.coroutines.flow.Flow

interface Preferences {

    suspend fun setName(name: String?)

    fun getName(): Flow<String?>

}