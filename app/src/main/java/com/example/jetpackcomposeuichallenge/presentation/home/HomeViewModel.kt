package com.example.jetpackcomposeuichallenge.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.jetpackcomposeuichallenge.domain.usecases.get_news.NewsUseCases
import com.example.jetpackcomposeuichallenge.presentation.search.SearchEvent
import com.example.jetpackcomposeuichallenge.presentation.search.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : ViewModel() {

    private val _uiState = mutableStateOf(SearchState())
    val uiState : State<SearchState> = _uiState


    var news = newsUseCases.getNews(
        sources = listOf("bbc-news", "abc-news", "al-jazeera-english")
    ).cachedIn(viewModelScope)



    fun onEvent(event: SearchEvent){
        when(event){
            is SearchEvent.UpdateSearchQuery -> {
                _uiState.value = uiState.value.copy(
                    searchQuery = event.searchQuery
                )
            }

            is SearchEvent.SearchNews -> {
                searchNews()
            }
        }
    }



    private fun searchNews() {
        val articles = newsUseCases.searchNews(
            searchQuery = uiState.value.searchQuery,
            sources = listOf("bbc-news", "abc-news", "al-jazeera-english")
        ).cachedIn(viewModelScope)

        news = articles

        _uiState.value = uiState.value.copy(articles = articles)
    }
}