package com.sunasterisk.myimageshow.screen

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.sunasterisk.myimageshow.data.resource.remote.repository.ImageRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel(private val repository: ImageRepository, val context: Context){

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun loadPage(keyWord: String, perPage: Int) {
        val disposable = repository.getSearchImageByKeyWord(keyWord, perPage)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {result -> Log.d("DAT OC", result.totalPages.toString())},
                {error -> Toast.makeText(context, error.message, Toast.LENGTH_LONG).show()}
            )
        compositeDisposable.add(disposable)
    }
}