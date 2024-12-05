package com.desafio.feed.domain.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}
