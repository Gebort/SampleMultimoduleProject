package com.gerbort.database.util

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.time.Instant

internal class InstantConverter {
    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun longToInstant(value: String?): Instant? =
        value?.let(Instant::parse)

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun instantToLong(instant: Instant?): String? =
        instant?.toString()
}