package com.gerbort.data.domain

import kotlinx.coroutines.flow.Flow

interface NetworkMonitor {

    fun isConnected(): Flow<Boolean>

    fun getStatus(): Flow<NetworkStatus>

}

sealed interface NetworkStatus {
    data class Connected(val isWifi: Boolean): NetworkStatus
    data object Losing: NetworkStatus
    data object Lost: NetworkStatus
    data object Unavailable: NetworkStatus
}