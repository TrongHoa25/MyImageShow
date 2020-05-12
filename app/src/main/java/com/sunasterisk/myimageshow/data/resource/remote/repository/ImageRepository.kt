package com.sunasterisk.myimageshow.data.resource.remote.repository

import com.sunasterisk.myimageshow.data.model.collection.Collection
import com.sunasterisk.myimageshow.data.model.photos.PageResult
import com.sunasterisk.myimageshow.data.model.photos.Result
import com.sunasterisk.myimageshow.data.resource.local.ImageLocalDataSource
import com.sunasterisk.myimageshow.data.resource.remote.ImageRemoteDataSource
import io.reactivex.rxjava3.core.Observable

interface ImageRepository {
    fun getSearchImageByKeyWord(keyWord: String, perPage: Int): Observable<PageResult>?
    fun getCollectionPhotosById(id: String): Observable<List<Result>>?
    fun getCollectionListByPage(page: Int): Observable<Collection>?
}

class ImageRepositoryImpl(
    private val local: ImageLocalDataSource,
    private val remote: ImageRemoteDataSource
) : ImageRepository {

    override fun getSearchImageByKeyWord(keyWord: String, perPage: Int): Observable<PageResult>? =
        remote.getImageByKeyWord(keyWord, perPage)

    override fun getCollectionPhotosById(id: String): Observable<List<Result>>? =
        remote.getCollectionPhotosById(id)

    override fun getCollectionListByPage(page: Int): Observable<Collection>? =
        remote.getCollectionListByPage(page)

    companion object {
        private var INSTANCE: ImageRepositoryImpl? = null
        fun getInstance(
            local: ImageLocalDataSource,
            remote: ImageRemoteDataSource) = INSTANCE ?: synchronized(this) {
            INSTANCE ?: ImageRepositoryImpl(local, remote).also { INSTANCE = it }
        }
    }
}
