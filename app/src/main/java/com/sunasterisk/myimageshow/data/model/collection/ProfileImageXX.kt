package com.sunasterisk.myimageshow.data.model.collection


import com.google.gson.annotations.SerializedName

data class ProfileImageXX(
    @SerializedName("large")
    val large: String,
    @SerializedName("medium")
    val medium: String,
    @SerializedName("small")
    val small: String
)
