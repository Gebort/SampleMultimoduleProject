package com.gerbort.sync.workers

import androidx.work.Constraints
import androidx.work.NetworkType

internal val SyncConstraints
    get() = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.CONNECTED)
        .build()