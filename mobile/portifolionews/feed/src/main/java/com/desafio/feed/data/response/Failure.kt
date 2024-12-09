package com.desafio.feed.data.response

sealed class Failure(
    val code: Int? = -1,
) : Exception() {
    data class GenericError(
        val codeStatus: Int? = -12, private val msg: String? = null
    ) : Failure(
        codeStatus
    )
}
