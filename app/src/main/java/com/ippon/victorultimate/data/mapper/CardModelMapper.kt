package com.ippon.victorultimate.data.mapper

import com.ippon.victorultimate.data.services.dto.DataDto
import com.ippon.victorultimate.domain.models.CardDetailModel
import com.ippon.victorultimate.domain.models.CardModel

fun DataDto.mapToCardModel(): CardModel = CardModel(
    name = name,
    urlImage = cardImages.first().imageUrlCropped,
    type = type,
    description = desc,
    attack = atk,
    defense = def,
    level = level,
    id = id,
)

fun DataDto.mapToCardDetailModel(): CardDetailModel = CardDetailModel(
    name = name,
    urlImage = cardImages.first().imageUrl,
    type = type,
    description = desc,
    attack = atk,
    defense = def,
    level = level,
    id = id,
    attribute = attribute,
)