package com.ippon.victorultimate.utils

import retrofit2.Response

object Tools {
    suspend fun <T, V> apiCall(
        defaultValue: T,
        getResponse: suspend () -> Response<V>,
        mapTo: (V) -> T
    ): T {
        val response = getResponse()
        if (!response.isSuccessful || response.errorBody() != null) {
            return defaultValue
        }
        return response.body()?.let(mapTo) ?: defaultValue
    }
}