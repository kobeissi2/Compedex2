package com.kobeissidev.jetpackcomposepokedex.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.paging.compose.LazyPagingItems

/**
 * Returns the TAG for the caller.
 */
inline val <reified T> T.TAG get() = T::class.java.simpleName

/**
 * Allows the usage of lazyPagingItems as an item for a LazyVerticalGrid.
 * @param lazyPagingItems contains the data collected.
 */
inline fun <T : Any> LazyGridScope.items(
    lazyPagingItems: LazyPagingItems<T>,
    crossinline itemContent: @Composable (value: T) -> Unit
) {
    items(lazyPagingItems.itemCount) { index ->
        lazyPagingItems.peek(index)?.let { item -> itemContent(item) }
    }
}

/**
 * Checks connectivity transports and returns if has internet access.
 */
val Context.isOnline: Boolean
    get() {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)?.let {
            when {
                it.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                it.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                it.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } ?: false
    }

/**
 * Split up the string by the - delimiter and rejoin with each first letter capitalized
 */
val String.removeDash
    get() = split(Dash)
        .joinToString(separator = " ") { splitString ->
            splitString.capitalize(Locale.current)
        }

/**
 * Split up the list of strings by the - delimiter and rejoin with each first letter capitalized
 */
val List<String>.removeDash
    get() = joinToString(separator = Slash.toString()) { joinedString ->
        joinedString.capitalize(Locale.current).split('-')
            .joinToString(" ") { splitString ->
                splitString.capitalize(Locale.current)
            }
    }

/**
 * Grabs the id from the url provided.
 */
val String.extractId get() = dropLastWhile { it == Slash }.takeLastWhile { it.isDigit() }