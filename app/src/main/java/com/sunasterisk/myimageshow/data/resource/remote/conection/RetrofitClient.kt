package com.sunasterisk.myimageshow.data.resource.remote.conection

import com.sunasterisk.myimageshow.data.resource.api.ImageService
import com.sunasterisk.myimageshow.utils.Constants
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    private var imageService: ImageService? = null

    private object HOLDER {
        val INSTANCE = RetrofitClient()
    }

    fun getImageService(): ImageService? {
        if (imageService == null) {
            imageService = provideRetrofit().create(ImageService::class.java)
        }
        return imageService
    }

    private fun provideRetrofit(): Retrofit {
        val logging: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
            .addInterceptor(logging)
            .addInterceptor(RequestInterceptor())
            .build()

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    companion object {
        const val READ_TIMEOUT = 5000L
        const val WRITE_TIMEOUT = 5000L
        const val CONNECT_TIMEOUT = 5000L

        val instance: RetrofitClient by lazy { HOLDER.INSTANCE }
    }
}
