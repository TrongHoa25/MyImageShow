package com.sunasterisk.myimageshow.data.model.photos


import com.google.gson.annotations.SerializedName
import com.sunasterisk.myimageshow.data.model.photos.Ancestry
import com.sunasterisk.myimageshow.data.model.photos.CoverPhoto

data class Source(
    @SerializedName("ancestry")
    val ancestry: Ancestry,
    @SerializedName("cover_photo")
    val coverPhoto: CoverPhoto,
    @SerializedName("description")
    val description: String,
    @SerializedName("meta_description")
    val metaDescription: String,
    @SerializedName("meta_title")
    val metaTitle: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("title")
    val title: String
)
