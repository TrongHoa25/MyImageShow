package com.sunasterisk.myimageshow.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sunasterisk.myimageshow.R
import com.sunasterisk.myimageshow.data.resource.local.ImageLocalDataSource
import com.sunasterisk.myimageshow.data.resource.remote.ImageRemoteDataSource
import com.sunasterisk.myimageshow.data.resource.remote.conection.RetrofitClient
import com.sunasterisk.myimageshow.data.resource.remote.repository.ImageRepository
import com.sunasterisk.myimageshow.data.resource.remote.repository.ImageRepositoryImpl

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var imageRepositoryImpl: ImageRepositoryImpl
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageRepositoryImpl = ImageRepositoryImpl(ImageLocalDataSource.instance, ImageRemoteDataSource.getInstance(
            RetrofitClient(this)
        ))
        mainViewModel = MainViewModel(imageRepositoryImpl,this)
        mainViewModel.loadPage("Sexy girl", 20)
    }
}
