package com.sunasterisk.myimageshow.data.model


import com.google.gson.annotations.SerializedName

data class Type(
    @SerializedName("pretty_slug")
    val prettySlug: String,
    @SerializedName("slug")
    val slug: String
)
