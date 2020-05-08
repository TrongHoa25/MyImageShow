package com.sunasterisk.myimageshow.data.resource.local

import com.sunasterisk.myimageshow.data.resource.ImageDataSource

class ImageLocalDataSource : ImageDataSource.local {

    private object HOLDER {
        val INSTANCE = ImageLocalDataSource()
    }

    companion object {
        val instance: ImageLocalDataSource by lazy { HOLDER.INSTANCE }
    }
}
