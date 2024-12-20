package com.paulajustino.worldinfocusapp.utils

/**
 * Representa um resultado de uma operação.
 *
 * @param D Tipo de dados em caso de sucesso.
 * @param E Tipo de erro em caso de falha.
 */
sealed class Result <out D, out E> {
    /**
     * Resultado de sucesso.
     *
     * @param data Dados retornados em caso de sucesso.
     */
    data class Success <D> (val data: D) : Result<D, Nothing>()

    /**
     * Resultado de erro.
     *
     * @param error Mensagem ou objeto de erro.
     */
    data class Error <E> (val error: E) : Result<Nothing, E>()
}