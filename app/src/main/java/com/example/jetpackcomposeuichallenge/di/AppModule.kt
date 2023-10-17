package com.example.jetpackcomposeuichallenge.di

import android.app.Application
import com.example.jetpackcomposeuichallenge.data.manager.LocalManagerImpl
import com.example.jetpackcomposeuichallenge.domain.manager.LocalManager
import com.example.jetpackcomposeuichallenge.domain.usecases.app_entry.AppEntryUseCases
import com.example.jetpackcomposeuichallenge.domain.usecases.app_entry.ReadAppEntry
import com.example.jetpackcomposeuichallenge.domain.usecases.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalManager = LocalManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localManager: LocalManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localManager),
        saveAppEntry = SaveAppEntry(localManager)
    )


}