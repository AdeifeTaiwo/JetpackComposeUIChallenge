package com.example.jetpackcomposeuichallenge.di

import android.app.Application
import androidx.room.Room
import com.example.jetpackcomposeuichallenge.data.local.database.NewsDao
import com.example.jetpackcomposeuichallenge.data.local.database.NewsDatabase
import com.example.jetpackcomposeuichallenge.data.local.database.NewsTypeConverter
import com.example.jetpackcomposeuichallenge.data.manager.LocalManagerImpl
import com.example.jetpackcomposeuichallenge.data.remote.NewsApi
import com.example.jetpackcomposeuichallenge.data.remote.repository.NewsRepositoryImpl
import com.example.jetpackcomposeuichallenge.domain.manager.LocalManager
import com.example.jetpackcomposeuichallenge.domain.repository.NewsRepository
import com.example.jetpackcomposeuichallenge.domain.usecases.app_entry.AppEntryUseCases
import com.example.jetpackcomposeuichallenge.domain.usecases.app_entry.ReadAppEntry
import com.example.jetpackcomposeuichallenge.domain.usecases.app_entry.SaveAppEntry
import com.example.jetpackcomposeuichallenge.domain.usecases.get_news.DeleteArticle
import com.example.jetpackcomposeuichallenge.domain.usecases.get_news.GetNews
import com.example.jetpackcomposeuichallenge.domain.usecases.get_news.NewsUseCases
import com.example.jetpackcomposeuichallenge.domain.usecases.get_news.SearchNews
import com.example.jetpackcomposeuichallenge.domain.usecases.get_news.SelectArticle
import com.example.jetpackcomposeuichallenge.domain.usecases.get_news.SelectArticles
import com.example.jetpackcomposeuichallenge.domain.usecases.get_news.UpsertArticle
import com.example.jetpackcomposeuichallenge.utility.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
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

    @Provides
    @Singleton
    fun providesNewsApi(): NewsApi {
        return Retrofit.Builder().baseUrl(
            BASE_URL
        ).addConverterFactory(GsonConverterFactory.create())
            .build().create(NewsApi::class.java)
    }


    @Provides
    @Singleton
    fun provideNewsRepository(newsApi: NewsApi): NewsRepository {
        return NewsRepositoryImpl(newsApi)
    }

    @Provides
    @Singleton
    fun providesNewsUseCases(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            deleteArticle = DeleteArticle(newsDao),
            selectArticles = SelectArticles(newsDao),
            upsertArticle = UpsertArticle(newsDao),
            selectArticle = SelectArticle(newsDao)
        )
    }

    @Provides
    @Singleton
    fun providesNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = "news_db"
        ).addTypeConverter(NewsTypeConverter())
            .fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton

    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao


}