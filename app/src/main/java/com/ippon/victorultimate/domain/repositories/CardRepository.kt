package com.ippon.victorultimate.domain.repositories

import com.ippon.victorultimate.domain.models.CardDetailModel
import com.ippon.victorultimate.domain.models.CardModel

interface CardRepository {
    suspend fun getCardsModels(): List<CardModel>

    suspend fun getCardDetailModel(id: Int): CardDetailModel?
}