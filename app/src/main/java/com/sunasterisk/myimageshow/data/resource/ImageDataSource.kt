package com.sunasterisk.myimageshow.data.resource

import com.sunasterisk.myimageshow.data.model.PageResult
import io.reactivex.rxjava3.core.Observable

interface ImageDataSource {
    interface local {
    }

    interface remote {
        fun getImageByKeyWord(keyWord: String, parPage: Int): Observable<PageResult>
    }
}
