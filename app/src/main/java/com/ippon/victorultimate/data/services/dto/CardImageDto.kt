package com.ippon.victorultimate.data.services.dto


import com.google.gson.annotations.SerializedName

data class CardImageDto(
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("image_url_cropped")
    val imageUrlCropped: String,
    @SerializedName("image_url_small")
    val imageUrlSmall: String
)