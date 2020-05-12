package com.sunasterisk.myimageshow.data.model.photos


import com.google.gson.annotations.SerializedName

data class PageResult(
    val results: List<Result>,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)
