package com.gerbort.login.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun LoginScreen(
    navigator: DestinationsNavigator,
    vm: LoginViewModel = hiltViewModel(),
) {

    Login(
        state = vm.state.collectAsState().value,
        onSaveName = { newName -> vm.onEvent(LoginEvent.SaveName(newName))}
    )
}

@Preview
@Composable
private fun Login(
    state: LoginScreenState = LoginScreenState(),
    onSaveName: (String) -> Unit = {}
) {

    var currentName by remember(state.user) {
        mutableStateOf(state.user?.name ?: "")
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        TextField(
            value = currentName,
            onValueChange = {currentName = it}
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onSaveName(currentName) }
        ) {
            Text(text = "Save name")
        }

    }
}

