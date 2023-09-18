package com.example.jetpackcomposeuichallenge.extensions

import android.util.Log
import androidx.compose.foundation.lazy.LazyListLayoutInfo


// Returns the normalized center item offset (-1,1)
fun LazyListLayoutInfo.normalizedItemPosition(key: Any): Float =
    visibleItemsInfo
        .firstOrNull { it.key == key }
        ?.let {
            val center = (viewportEndOffset + viewportStartOffset)
            (it.offset.toFloat() - center) / center

        }
        ?: 0F