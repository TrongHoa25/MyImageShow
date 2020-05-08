package com.sunasterisk.myimageshow.data.resource.remote.repository

import com.sunasterisk.myimageshow.data.model.PageResult
import com.sunasterisk.myimageshow.data.resource.ImageDataSource
import com.sunasterisk.myimageshow.data.resource.local.ImageLocalDataSource
import com.sunasterisk.myimageshow.data.resource.remote.ImageRemoteDataSource
import io.reactivex.rxjava3.core.Observable

interface ImageRepository {
    fun getSearchImageByKeyWord(keyWord: String, perPage: Int): Observable<PageResult>
}

class ImageRepositoryImpl(
    val local: ImageLocalDataSource,
    val remote: ImageRemoteDataSource
) : ImageRepository {

    override fun getSearchImageByKeyWord(keyWord: String, perPage: Int): Observable<PageResult> =
        remote.getImageByKeyWord(keyWord, perPage)
}
