package com.example.jetpackcomposeuichallenge.presentation


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.room.Room
import com.example.jetpackcomposeuichallenge.MainCoroutineRule
import com.example.jetpackcomposeuichallenge.data.local.database.NewsDao
import com.example.jetpackcomposeuichallenge.data.local.database.NewsDatabase
import com.example.jetpackcomposeuichallenge.data.remote.NewsApi
import com.example.jetpackcomposeuichallenge.domain.NewsRepositoryImpl
import com.example.jetpackcomposeuichallenge.domain.usecases.get_news.DeleteArticle
import com.example.jetpackcomposeuichallenge.domain.usecases.get_news.GetNews
import com.example.jetpackcomposeuichallenge.domain.usecases.get_news.NewsUseCases
import com.example.jetpackcomposeuichallenge.domain.usecases.get_news.SearchNews
import com.example.jetpackcomposeuichallenge.domain.usecases.get_news.SelectArticle
import com.example.jetpackcomposeuichallenge.domain.usecases.get_news.SelectArticles
import com.example.jetpackcomposeuichallenge.domain.usecases.get_news.UpsertArticle
import com.example.jetpackcomposeuichallenge.presentation.home.HomeViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.http.GET
import junit.framework.TestCase.assertTrue

class HomeViewModelTest {
    lateinit var viewModel: HomeViewModel

    val newsRepository = NewsRepositoryImpl()
    private lateinit var newsDao : NewsDao

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Before
    fun setUp(){

        viewModel = HomeViewModel(
            newsUseCases = NewsUseCases(
                GetNews(newsRepository),
                SearchNews(newsRepository),
                deleteArticle = DeleteArticle(newsDao),
                selectArticles = SelectArticles(newsDao),
                upsertArticle = UpsertArticle(newsDao),
                selectArticle = SelectArticle(newsDao)

            )
        )
    }

    @Test
    fun assert_news_is_empty() = runBlocking{
       assertTrue(viewModel.news.collect().toString().isEmpty())
    }
}