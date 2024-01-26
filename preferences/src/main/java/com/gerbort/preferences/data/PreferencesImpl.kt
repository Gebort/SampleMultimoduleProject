package com.gerbort.preferences.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.gerbort.common.di.AppDispatchers
import com.gerbort.common.di.ApplicationScope
import com.gerbort.common.di.Dispatcher
import com.gerbort.common.logging.log
import com.gerbort.common.logging.logInfo
import com.gerbort.preferences.domain.Preferences
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class PreferencesImpl @Inject constructor(
    @ApplicationScope private val context: Context,
    @Dispatcher(AppDispatchers.IO) private val dispatcher: CoroutineDispatcher,
    @ApplicationScope scope: CoroutineScope,
): Preferences {

    private val Context.dataStore: DataStore<androidx.datastore.preferences.core.Preferences>
    by preferencesDataStore(name = PreferencesKeys.STORE_NAME)

    private val _name = context.dataStore.data
        .map { preferences ->
            val name = preferences[PreferencesKeys.NAME]
            if (name.isNullOrBlank()) {
                null
            } else {
                name
            }
        }
        .distinctUntilChanged { old, new -> old == new }
        .onEach { log("Сохраненное имя - $it") }
        .shareIn(scope, SharingStarted.Eagerly, replay = 1)

    override suspend fun setName(name: String?) = withContext(dispatcher) {
        if (name == _name.first()) return@withContext
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.NAME] = name.orEmpty()
        }
        logInfo( "Изменение настроек, имя - $name")
    }

    override fun getName(): Flow<String?> = _name

    private object PreferencesKeys{
        const val STORE_NAME = "preferences"
        val NAME = stringPreferencesKey("name")

    }

}