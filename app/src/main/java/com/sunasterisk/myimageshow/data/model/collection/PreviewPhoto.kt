package com.sunasterisk.myimageshow.data.model.collection


import com.google.gson.annotations.SerializedName

data class PreviewPhoto(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("urls")
    val urls: UrlsX
)
