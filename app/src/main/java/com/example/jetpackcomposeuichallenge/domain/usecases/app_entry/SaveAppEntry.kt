package com.example.jetpackcomposeuichallenge.domain.usecases.app_entry

import com.example.jetpackcomposeuichallenge.domain.manager.LocalManager

class SaveAppEntry (private val localUserManager: LocalManager) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }

}