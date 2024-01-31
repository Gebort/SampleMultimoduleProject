package com.gerbort.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gerbort.common.logging.log
import com.gerbort.common.model.User
import com.gerbort.networking.domain.NetworkDataSource
import com.gerbort.networking.domain.NetworkMonitor
import com.gerbort.preferences.domain.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val preferences: Preferences,
    private val networkMonitor: NetworkMonitor,
    private val networkDataSource: NetworkDataSource
): ViewModel() {

    private val _state = MutableStateFlow(LoginScreenState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            preferences.getName().collect { name ->
                _state.update { it.copy(user = if (name == null) null else User(name)) }
            }
        }
        viewModelScope.launch {
            networkMonitor.isConnected().collect { isConnected ->
                _state.update { it.copy(isConnected = isConnected) }
            }
        }
    }

    fun onEvent(event: LoginEvent) {
        viewModelScope.launch {
            when (event) {
                is LoginEvent.SaveName -> preferences.setName(event.newName)
            }
        }
    }

}