package com.ippon.victorultimate.data.repositories

import androidx.compose.ui.text.intl.Locale
import com.ippon.victorultimate.data.mapper.mapToCardDetailModel
import com.ippon.victorultimate.data.mapper.mapToCardModel
import com.ippon.victorultimate.data.services.CardService
import com.ippon.victorultimate.domain.models.CardDetailModel
import com.ippon.victorultimate.domain.models.CardModel
import com.ippon.victorultimate.domain.repositories.CardRepository
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val cardService: CardService,
): CardRepository {
    override suspend fun getCardsModels(): List<CardModel> {
        val language = Locale.current.language
        val response = cardService.getAllCards(
            language = if (language == "en") null else language
        )
        if (!response.isSuccessful && response.errorBody() != null) {
            return emptyList()
        }
        return response.body()?.data?.map { it.mapToCardModel() } ?: emptyList()
    }

    override suspend fun getCardDetailModel(id: Int): CardDetailModel? {
        val language = Locale.current.language
        val response = cardService.getCardInfo(
            id = id,
            language = if (language == "en") null else language
        )
        if (!response.isSuccessful && response.errorBody() != null) {
            return null
        }
        return response.body()?.data?.firstOrNull()?.mapToCardDetailModel()

    }
}