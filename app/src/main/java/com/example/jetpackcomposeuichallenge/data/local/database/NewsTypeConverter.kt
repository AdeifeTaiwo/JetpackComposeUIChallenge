package com.example.jetpackcomposeuichallenge.data.local.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.jetpackcomposeuichallenge.domain.model.Source

@ProvidedTypeConverter
class NewsTypeConverter {
    @TypeConverter
    fun sourceToString(source: Source): String {
        return "${source.id},${source.name}"
    }

    @TypeConverter
    fun stringToSource(sourceAsString: String): Source {
        return sourceAsString.split(",").let { sourceArray ->
            Source(sourceArray[0], sourceArray[1])
        }
    }
}