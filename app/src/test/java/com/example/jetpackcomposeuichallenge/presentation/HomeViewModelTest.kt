package com.example.jetpackcomposeuichallenge.presentation


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.compose.runtime.collectAsState
import com.example.jetpackcomposeuichallenge.MainCoroutineRule
import com.example.jetpackcomposeuichallenge.data.remote.NewsApi
import com.example.jetpackcomposeuichallenge.domain.NewsRepositoryImpl
import com.example.jetpackcomposeuichallenge.domain.usecases.get_news.GetNews
import com.example.jetpackcomposeuichallenge.domain.usecases.get_news.NewsUseCases
import com.example.jetpackcomposeuichallenge.presentation.home.HomeViewModel
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

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Before
    fun setUp(){
        viewModel = HomeViewModel(
            newsUseCases = NewsUseCases(
                GetNews(newsRepository)
            )
        )
    }

    @Test
    fun assert_news_is_empty() = runBlocking{
       assertTrue(viewModel.news.collect().toString().isEmpty())
    }
}