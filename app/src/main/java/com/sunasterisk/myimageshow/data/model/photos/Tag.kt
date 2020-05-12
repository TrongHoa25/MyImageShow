package com.sunasterisk.myimageshow.data.model.photos


import com.google.gson.annotations.SerializedName
import com.sunasterisk.myimageshow.data.model.photos.Source

data class Tag(
    @SerializedName("source")
    val source: Source,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String
)
