package com.sunasterisk.myimageshow.data.resource.api

import com.sunasterisk.myimageshow.data.model.PageResult
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImageService {
    @GET("search/photos?")
    fun getSearchByKeyWord(
        @Query("query") keyWord: String,
        @Query("per_page") perPage : Int
    ): Observable<PageResult>
}
