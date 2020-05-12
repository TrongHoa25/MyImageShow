package com.sunasterisk.myimageshow.data.resource

import com.sunasterisk.myimageshow.data.model.collection.Collection
import com.sunasterisk.myimageshow.data.model.photos.PageResult
import com.sunasterisk.myimageshow.data.model.photos.Result
import io.reactivex.rxjava3.core.Observable

interface ImageDataSource {
    interface Local {}

    interface Remote {
        fun getImageByKeyWord(keyWord: String, parPage: Int): Observable<PageResult>?
        fun getCollectionPhotosById(id: String): Observable<List<Result>>?
        fun getCollectionListByPage(page: Int): Observable<Collection>?
    }
}
