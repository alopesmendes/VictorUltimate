package com.ippon.victorultimate.data.repositories

import androidx.compose.ui.text.intl.Locale
import com.ippon.victorultimate.data.mapper.mapToCardDetailModel
import com.ippon.victorultimate.data.mapper.mapToCardModel
import com.ippon.victorultimate.data.services.CardService
import com.ippon.victorultimate.domain.models.CardDetailModel
import com.ippon.victorultimate.domain.models.CardModel
import com.ippon.victorultimate.domain.repositories.CardRepository
import com.ippon.victorultimate.utils.Tools
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val cardService: CardService,
): CardRepository {
    override suspend fun getCardsModels(): List<CardModel> {
        return Tools.apiCall(
            defaultValue = emptyList(),
            getResponse = {
                val language = Locale.current.language
                cardService.getAllCards(
                    language = if (language == "en") null else language
                )
            },
            mapTo = { cardModelsDto ->
                cardModelsDto.data.map { it.mapToCardModel() }
            }
        )
    }

    override suspend fun getCardDetailModel(id: Int): CardDetailModel? {
        return Tools.apiCall(
            defaultValue = null,
            getResponse = {
                val language = Locale.current.language
                cardService.getCardInfo(
                    id = id,
                    language = if (language == "en") null else language
                )
            },
            mapTo = { cardModelsDto ->
                cardModelsDto.data.firstOrNull()?.mapToCardDetailModel()
            }
        )
    }
}