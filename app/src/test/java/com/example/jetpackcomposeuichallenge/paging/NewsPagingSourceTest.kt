package com.example.jetpackcomposeuichallenge.paging

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.PagingSource
import com.example.jetpackcomposeuichallenge.MainCoroutineRule
import com.example.jetpackcomposeuichallenge.data.remote.NewsApi
import com.example.jetpackcomposeuichallenge.data.remote.dto.NewsResponse
import com.example.jetpackcomposeuichallenge.data.remote.paging.NewsPagingSource
import com.example.jetpackcomposeuichallenge.domain.dummyItem
import com.example.jetpackcomposeuichallenge.domain.model.Article
import com.example.jetpackcomposeuichallenge.utility.Constants
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class NewssPagingSourceTest {


    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutineTestRule = MainCoroutineRule()

    @Mock
    lateinit var api: NewsApi

    lateinit var newsPagingSource: NewsPagingSource

    val newsResponse = NewsResponse(
        articles = dummyItem,
        status = "Successful",
        totalResults = 10
    )

    companion object {
        val nextNewResponse = NewsResponse(
            articles = dummyItem,
            status = "Failed",
            totalResults = 10
        )
    }

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        newsPagingSource = NewsPagingSource(newsApi = api, sources = "BBC-News")
    }


    @Test
    fun `reviews paging source load - failure - received null`() = runBlockingTest {
        given(api.getNews(0, "BBC-News", "Constants.API_KEY")).willReturn(null)

        val expectedResult = PagingSource.LoadResult.Error<Int, Article>(NullPointerException())
        assert(
            expectedResult.toString().contains("java.lang.NullPointerException") and newsPagingSource.load(
                PagingSource.LoadParams.Refresh(
                    key = 0,
                    loadSize = 1,
                    placeholdersEnabled = false
                )
            ).toString().contains("java.lang.NullPointerException")
        )
    }

    @Test
    fun `reviews paging source refresh - success`() = runBlockingTest {
        given(api.getNews(0, "BBC-News", Constants.API_KEY)).willReturn(newsResponse)

        val expectedResult = PagingSource.LoadResult.Page(
            data = newsResponse.articles,
            prevKey = null,
            nextKey = 1
        )

        assertEquals(
            expectedResult, newsPagingSource.load(
                PagingSource.LoadParams.Refresh(
                    key = 0,
                    loadSize = 1,
                    placeholdersEnabled = false
                )
            )
        )
    }


    @Test
    fun `reviews paging source append - success`() = runBlockingTest {
        given(api.getNews(1, "BBC-News", Constants.API_KEY)).willReturn(nextNewResponse)
        val expectedResult = PagingSource.LoadResult.Page(
            data = newsResponse.articles,
            prevKey = null,
            nextKey = 2
        )
        assertEquals(
            expectedResult, newsPagingSource.load(
                PagingSource.LoadParams.Append(
                    key = 1,
                    loadSize = 2,
                    placeholdersEnabled = false
                )
            )
        )
    }





}