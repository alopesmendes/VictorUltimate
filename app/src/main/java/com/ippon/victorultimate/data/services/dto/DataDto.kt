package com.ippon.victorultimate.data.services.dto


import com.google.gson.annotations.SerializedName

data class DataDto(
    val archetype: String?,
    val atk: Int?,
    val attribute: String?,
    @SerializedName("banlist_info")
    val banlistInfo: BanlistInfoDto?,
    @SerializedName("card_images")
    val cardImages: List<CardImageDto>,
    @SerializedName("card_prices")
    val cardPrices: List<CardPriceDto>,
    @SerializedName("card_sets")
    val cardSets: List<CardSetDto>?,
    val def: Int?,
    val desc: String,
    val frameType: String,
    val id: Int,
    val level: Int?,
    val linkmarkers: List<String>?,
    val linkval: Int?,
    @SerializedName("monster_desc")
    val monsterDesc: String?,
    val name: String,
    @SerializedName("pend_desc")
    val pendDesc: String?,
    val race: String,
    val scale: Int?,
    val type: String,
    @SerializedName("ygoprodeck_url")
    val ygoprodeckUrl: String
)