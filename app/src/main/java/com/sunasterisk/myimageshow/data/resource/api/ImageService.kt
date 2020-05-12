package com.sunasterisk.myimageshow.data.resource.api

import com.sunasterisk.myimageshow.data.model.collection.Collection
import com.sunasterisk.myimageshow.data.model.photos.PageResult
import com.sunasterisk.myimageshow.data.model.photos.Result
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

    @GET("collections/{id}/photos?")
    fun getColectionPhotosById(
        @Path("id") id: String
    ): Observable<List<Result>>

    @GET("collections?")
    fun getCollectionListByPage(
        @Query("page") page: Int
    ): Observable<Collection>
}
