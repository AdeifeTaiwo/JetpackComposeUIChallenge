package com.example.jetpackcomposeuichallenge.data.remote

import com.example.jetpackcomposeuichallenge.data.remote.dto.NewsResponse
import com.example.jetpackcomposeuichallenge.utility.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") sources:String,
        @Query("apiKey") apiKey: String = API_KEY
    ) : NewsResponse


    @GET("everything")
    suspend fun searchNews(
    @Query("q") searcQuery: String,
        @Query("page") page: Int,
        @Query("sources") sources:String,
        @Query("apiKey") apiKey: String = API_KEY
    ) : NewsResponse



}