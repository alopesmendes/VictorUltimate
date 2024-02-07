package com.ippon.victorultimate.domain.models

data class CardDetailModel(
    val id: Int,
    val name: String,
    val urlImage: String,
    val type: String,
    val description: String,
    val attack: Int?,
    val defense: Int?,
    val level: Int?,
    val attribute: String?,
)
