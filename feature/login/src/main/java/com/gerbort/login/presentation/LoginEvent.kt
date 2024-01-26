package com.gerbort.login.presentation

sealed interface LoginEvent{
    class SaveName(val newName: String): LoginEvent
}