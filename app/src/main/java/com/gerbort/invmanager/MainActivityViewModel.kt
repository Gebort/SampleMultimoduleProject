package com.gerbort.invmanager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gerbort.common.model.User
import com.gerbort.data.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    userRepository: UserRepository
) : ViewModel() {
    val uiState: StateFlow<MainActivityUiState> = userRepository.getUser().map {
        MainActivityUiState.Success(it)
    }.stateIn(
        scope = viewModelScope,
        initialValue = MainActivityUiState.Loading,
        started = SharingStarted.WhileSubscribed(5_000),
    )
}

sealed interface MainActivityUiState {
    data object Loading : MainActivityUiState
    data class Success(val user: User?) : MainActivityUiState
}