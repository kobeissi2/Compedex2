package com.kobeissidev.jetpackcomposepokedex.util

import androidx.compose.runtime.Composable
import retrofit2.Response
import timber.log.Timber

/**
 * Helper class to contain the network data and states.
 * @param data contains the data if possible. Will not be null for Success cases.
 * @param message contains the error message if possible. Will not be null for Failure cases.
 */
sealed class NetworkResult<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Empty<T> : NetworkResult<T>()
    class Loading<T> : NetworkResult<T>()
    class Success<T>(data: T) : NetworkResult<T>(data = data)
    class Failure<T>(message: String) : NetworkResult<T>(message = message)
}

/**
 * Extension to the NetworkResult class to handle the different states.
 * @param onSuccess is an optional function to execute when the state is a success. The data is passed back to the user.
 * @param onLoading is an optional function to execute when the state is loading.
 * @param onFailure is an optional function to execute when the state is a failure. The error message is passed back to the user.
 */
@Composable
inline fun <T> NetworkResult<out T>.OnStateChanged(
    crossinline onLoading: (@Composable () -> Unit) = {},
    crossinline onFailure: (@Composable (String) -> Unit) = {},
    crossinline onSuccess: (@Composable (T) -> Unit) = {}
) = when (this) {
    is NetworkResult.Success -> onSuccess(data!!)
    is NetworkResult.Loading -> onLoading()
    is NetworkResult.Failure -> onFailure(message!!)
    else -> Unit
}

/**
 * Extension to the NetworkResult class to handle the different states with suspend functions.
 * Default suspend functions are not supported yet so none are optional for this version.
 * @param onSuccess is a function to execute when the state is a success. The data is passed back to the user.
 * @param onLoading is a function to execute when the state is loading.
 * @param onFailure is a function to execute when the state is a failure. The error message is passed back to the user.
 */
suspend inline fun <T> NetworkResult<out T>.suspendOnStateChanged(
    crossinline onSuccess: suspend ((T) -> Unit),
    crossinline onLoading: suspend (() -> Unit),
    crossinline onFailure: suspend ((String) -> Unit)
) = when (this) {
    is NetworkResult.Success -> onSuccess(data!!)
    is NetworkResult.Loading -> onLoading()
    is NetworkResult.Failure -> onFailure(message!!)
    else -> Unit
}

/**
 * Wrapper for network responses which converts it into the Network Result class.
 */
suspend fun <T> getResult(
    suspendFunction: suspend () -> Response<T>
) = try {
    suspendFunction().run {
        if (isSuccessful) {
            val body = body()!!
            Timber.d("Got Result: $body")
            NetworkResult.Success(body)
        } else {
            val message = message()
            Timber.e("Failed getting result with $message")
            NetworkResult.Failure(message)
        }
    }
} catch (exception: Exception) {
    Timber.e("Exception thrown while getting result $exception")
    NetworkResult.Failure(exception.message ?: exception.toString())
}