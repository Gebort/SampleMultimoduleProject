package com.gerbort.networking.data

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import com.gerbort.common.logging.log
import com.gerbort.networking.domain.NetworkMonitor
import com.gerbort.networking.domain.NetworkStatus
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class NetworkMonitorImpl @Inject constructor(
    @ApplicationContext private val context: Context,

): NetworkMonitor {

    private val _status = MutableStateFlow<NetworkStatus>(NetworkStatus.Unavailable)

    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    override fun isConnected(): Flow<Boolean> = _status.map {  status ->
        when (status) {
            is NetworkStatus.Connected -> true
            else -> false
        }
    }

    override fun getStatus(): Flow<NetworkStatus> = _status

    private val callback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            val isWifi = isWifiConnection()
            _status.update { NetworkStatus.Connected(isWifi) }
            log("Network connection available, wifi - $isWifi")
            super.onAvailable(network)
        }

        override fun onLosing(network: Network, maxMsToLive: Int) {
            super.onLosing(network, maxMsToLive)
            log("Losing network connection...")
            _status.update { NetworkStatus.Losing }
        }

        override fun onLost(network: Network) {
            super.onLost(network)
            log("Network connection lost")
            _status.update { NetworkStatus.Lost }
        }

        override fun onUnavailable() {
            super.onUnavailable()
            log("Network connection unavailable")
            _status.update { NetworkStatus.Unavailable }
        }
    }

    init {
        connectivityManager.registerDefaultNetworkCallback(callback)
    }

    private fun isWifiConnection(): Boolean {
        val activeNetwork = connectivityManager.activeNetworkInfo
        if (activeNetwork != null) { // connected to the internet
            return activeNetwork.type == ConnectivityManager.TYPE_WIFI
        }
        return false
    }


}