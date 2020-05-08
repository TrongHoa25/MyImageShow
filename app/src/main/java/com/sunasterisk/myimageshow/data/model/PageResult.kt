package com.sunasterisk.myimageshow.data.model


import com.google.gson.annotations.SerializedName

data class PageResult(
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)