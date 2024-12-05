package com.desafio.feed.data.response

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import retrofit2.Response

sealed class NetworkResponse<out T> {
    data class Success<out T>(
        val value: T
    ) : NetworkResponse<T>()

    data class Error(
        val body: Any? = null,
        @Transient
        val exception: Failure? = null
    ) : NetworkResponse<Nothing>()
}
suspend fun <T : Any> handleApi(
    execute: suspend () -> Response<T>
): NetworkResponse<T> {
    return try {
        val response = execute()
        val body = response.body()

        if (response.isSuccessful && body != null) {
            NetworkResponse.Success(body)
        } else {
            NetworkResponse.Error(NetworkResponse.Error(Exception()))
        }

    } catch (e: HttpException) {
        NetworkResponse.Error(e)
    } catch (e: Throwable) {
        NetworkResponse.Error(e)
    }
}

fun <T> NetworkResponse<T>.toResult(): Result<T> =
    when (this) {
        is NetworkResponse.Success -> {
            Result.success(this.value)
        }
        is NetworkResponse.Error -> {
            Result.failure(this.exception ?: Failure.GenericError())
        }
    }

fun <T> NetworkResponse<T>.toFlow(): Flow<T> {
    val networkResponse = this
    return flow {
        when (networkResponse) {
            is NetworkResponse.Success -> {
                emit(networkResponse.value)
            }
            is NetworkResponse.Error -> {
                throw networkResponse.exception ?: Failure.GenericError()
            }
        }
    }
}