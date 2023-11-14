package com.example.jetpackcomposeuichallenge.domain

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.jetpackcomposeuichallenge.data.remote.NewsApi
import com.example.jetpackcomposeuichallenge.data.remote.paging.NewsPagingSource
import com.example.jetpackcomposeuichallenge.domain.model.Article
import com.example.jetpackcomposeuichallenge.domain.model.Source
import com.example.jetpackcomposeuichallenge.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class NewsRepositoryImpl() : NewsRepository {


    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return flowOf()
    }

    override fun searchNew(searchQueery: String, sources: List<String>): Flow<PagingData<Article>> {
        return flowOf()
    }

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getNews(listOf("BBC-News"))
    }
}

val dummyItem = listOf<Article>(
    Article(
        author = "Taiwo",
        content = "Hello",
        description = "Nigeria beats china",
        publishedAt = "144343",
        source = Source(id = "1", name = "BBC"),
        url = "",
        urlToImage = "",
        title = "Ololade gbomo lo"
    )
)