package com.gerbort.sampleproject.logging

import android.util.Log
import com.gerbort.sampleproject.BuildConfig
import java.util.logging.Handler
import java.util.logging.Level
import java.util.logging.LogManager
import java.util.logging.LogRecord

class LoggingHandler : Handler() {

    override fun isLoggable(record: LogRecord?): Boolean =
        super.isLoggable(record) && BuildConfig.DEBUG

    override fun close() {
        // ignore
    }

    override fun flush() {
        // ignore
    }

    override fun publish(record: LogRecord) {
        val tag = record.loggerName
        val level = getAndroidLevel(record.level)
        val message = record.thrown?.let { thrown ->
            "${record.message}: ${Log.getStackTraceString(thrown)}"
        } ?: record.message

        try {
            Log.println(level, tag, message)
        } catch (e: RuntimeException) {
            Log.e(this.javaClass.simpleName, "Error logging message", e)
        }
    }

    private fun getAndroidLevel(level: Level): Int =
        when (level.intValue()) {
            Level.SEVERE.intValue() -> Log.ERROR
            Level.WARNING.intValue() -> Log.WARN
            Level.INFO.intValue() -> Log.INFO
            Level.FINE.intValue() -> Log.DEBUG
            else -> Log.DEBUG
        }

    companion object {
        fun setup() {
            val rootLogger = LogManager.getLogManager().getLogger("")
            for (handler in rootLogger.handlers) {
                rootLogger.removeHandler(handler)
            }
            rootLogger.addHandler(LoggingHandler())
            rootLogger.level = Level.FINE
        }
    }
}