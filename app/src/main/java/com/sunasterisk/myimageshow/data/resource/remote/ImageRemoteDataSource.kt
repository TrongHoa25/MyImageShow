package com.sunasterisk.myimageshow.data.resource.remote

import com.sunasterisk.myimageshow.data.model.PageResult
import com.sunasterisk.myimageshow.data.resource.ImageDataSource
import com.sunasterisk.myimageshow.data.resource.api.ImageService
import com.sunasterisk.myimageshow.data.resource.remote.conection.RetrofitClient
import io.reactivex.rxjava3.core.Observable

class ImageRemoteDataSource(retrofitClient: RetrofitClient) : ImageDataSource.Remote {

    private val requestService = retrofitClient.getImageService()

    override fun getImageByKeyWord(keyWord: String, perPage: Int): Observable<PageResult>? =
        requestService?.getSearchByKeyWord(keyWord, perPage)

    companion object {
        var instance: ImageRemoteDataSource? = null
        @JvmStatic
        fun getInstance(retrofitClient: RetrofitClient): ImageRemoteDataSource {
            if (instance == null) {
                synchronized(ImageRemoteDataSource::javaClass) {
                    instance = ImageRemoteDataSource(retrofitClient)
                }
            }
            return instance!!
        }
    }
}
