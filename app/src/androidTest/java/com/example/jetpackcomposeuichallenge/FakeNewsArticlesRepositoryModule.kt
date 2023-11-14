package com.example.jetpackcomposeuichallenge

import android.app.Application
import androidx.paging.PagingData
import androidx.room.Room
import com.example.jetpackcomposeuichallenge.data.local.LocalNewsDataProvider
import com.example.jetpackcomposeuichallenge.data.local.database.NewsDao
import com.example.jetpackcomposeuichallenge.data.local.database.NewsDatabase
import com.example.jetpackcomposeuichallenge.data.local.database.NewsTypeConverter
import com.example.jetpackcomposeuichallenge.data.manager.LocalManagerImpl
import com.example.jetpackcomposeuichallenge.di.AppModule
import com.example.jetpackcomposeuichallenge.domain.manager.LocalManager
import com.example.jetpackcomposeuichallenge.domain.model.Article
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
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Singleton


@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AppModule::class]
)
@Module
object FakeNewsArticlesRepositoryModule {
    @Singleton
    @Provides
    fun providesFakeNewsArticlesRepository() = object : NewsRepository {
        override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
            return flowOf()
        }

        override fun searchNew(
            searchQuery: String,
            sources: List<String>
        ): Flow<PagingData<Article>> {
            return flowOf()
        }

    }

    @Provides
    @Singleton
    fun providesFakeNewsUseCases(
        newsDao: NewsDao,
        newsRepository: NewsRepository
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
    fun provideFakeLocalUserManager(
        application: Application
    ): LocalManager = LocalManagerImpl(application)

    @Provides
    @Singleton
    fun provideFakeAppEntryUseCases(
        localManager: LocalManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localManager),
        saveAppEntry = SaveAppEntry(localManager)
    )

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