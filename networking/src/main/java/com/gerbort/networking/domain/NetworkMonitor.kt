package com.gerbort.networking.domain

import kotlinx.coroutines.flow.Flow


interface NetworkMonitor {

    fun isConnected(): Flow<Boolean>

}