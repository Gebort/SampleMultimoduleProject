package com.gerbort.networking.data

import com.gerbort.networking.domain.NetworkMonitor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class NetworkMonitorImpl: NetworkMonitor {

    private val _status = MutableStateFlow(true)
    override fun isConnected(): Flow<Boolean> = _status


}