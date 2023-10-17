package com.example.jetpackcomposeuichallenge.domain.manager

import kotlinx.coroutines.flow.Flow

interface LocalManager {
    suspend fun saveAppEntry()

    suspend fun readAppEntry(): Flow<Boolean>

}