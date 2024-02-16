package com.example.jetpackcomposeuichallenge.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.jetpackcomposeuichallenge.domain.manager.LocalManager
import com.example.jetpackcomposeuichallenge.utility.Constants
import com.example.jetpackcomposeuichallenge.utility.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalManagerImpl(private val context: Context) : LocalManager {
    override suspend fun saveAppEntry() {
        context.datastore.edit { settings ->
            settings[PreferenceKeys.APP_ENTRY] = true
        }
    }
    override suspend fun readAppEntry(): Flow<Boolean> {
        return context.datastore.data.map {preferences ->
            preferences[PreferenceKeys.APP_ENTRY]?:false
        }
    }
}

private val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)
//two types of datastore,
private object PreferenceKeys{
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
}

