package com.gerbort.common.logging

import java.util.logging.Level
import java.util.logging.Logger

fun Any.log(message: String) {
    logger.log(Level.FINE, message)
}

fun Any.logInfo(message: String) {
    logger.log(Level.INFO, message)
}

fun Any.logError(message: String) {
    logger.log(Level.SEVERE, message)
}

fun Any.logError(message: String, throwable: Throwable) {
    logger.log(Level.SEVERE, message, throwable)
}

private val Any.logger: Logger
    get() = Logger.getLogger(this::class.java.simpleName)