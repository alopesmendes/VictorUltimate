package com.ippon.victorultimate.data.services

import com.ippon.victorultimate.data.services.dto.CardModelsDto
import org.intellij.lang.annotations.Language
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CardService {
    @GET("cardinfo.php")
    suspend fun getAllCards(
        @Query("language") language: String?
    ): Response<CardModelsDto>

    @GET("cardinfo.php")
    suspend fun getCardInfo(
        @Query("id") id: Int,
        @Query("language") language: String?
    ): Response<CardModelsDto>
}