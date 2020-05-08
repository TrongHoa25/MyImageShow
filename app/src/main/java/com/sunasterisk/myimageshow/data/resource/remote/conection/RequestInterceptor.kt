package com.sunasterisk.myimageshow.data.resource.remote.conection

import com.sunasterisk.myimageshow.utils.Constants
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request().let {
            it.newBuilder().url(
                it.url.newBuilder()
                    .addQueryParameter(Constants.CLIENT_ID, Constants.API_KEY)
                    .build()
            ).build()
        })
    }
}
