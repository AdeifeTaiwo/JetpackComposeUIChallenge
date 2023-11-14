package com.example.jetpackcomposeuichallenge.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.jetpackcomposeuichallenge.data.local.database.NewsTypeConverter
import kotlin.random.Random
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    @PrimaryKey
    val url: String,
    val urlToImage: String,
) : Parcelable{
    fun setGenr() : String{
        val randomGenreList = listOf("Politics", "Sports", "Food", "Health")
        val randomNumber = (0..3).random()
       return randomGenreList[randomNumber]
    }

}