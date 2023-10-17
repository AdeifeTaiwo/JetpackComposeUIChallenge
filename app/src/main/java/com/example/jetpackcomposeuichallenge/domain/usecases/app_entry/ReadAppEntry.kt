package com.example.jetpackcomposeuichallenge.domain.usecases.app_entry

import com.example.jetpackcomposeuichallenge.domain.manager.LocalManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry (private val localUserManager: LocalManager) {
    suspend operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }

}