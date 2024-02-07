package com.ippon.victorultimate.data.services.dto


import com.google.gson.annotations.SerializedName

data class BanlistInfoDto(
    @SerializedName("ban_goat")
    val banGoat: String?,
    @SerializedName("ban_ocg")
    val banOcg: String?,
    @SerializedName("ban_tcg")
    val banTcg: String?
)