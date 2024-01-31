package com.gerbort.login.presentation

import com.gerbort.common.model.User

data class LoginScreenState(
    val isLoading: Boolean = true,
    val isConnected: Boolean = false,
    val user: User? = null
)
