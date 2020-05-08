package com.sunasterisk.myimageshow.screen

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.sunasterisk.myimageshow.data.resource.remote.repository.ImageRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel(private val context: Context, private val repository: ImageRepository){

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun loadPage(keyWord: String, perPage: Int) {
        val disposable = repository.getSearchImageByKeyWord(keyWord, perPage)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {result -> Log.d(TAG, result.totalPages.toString())},
                {error -> Toast.makeText(context, error.message, Toast.LENGTH_LONG).show()}
            )
        compositeDisposable.add(disposable)
    }

    companion object {
        private val TAG = MainViewModel::class.java.simpleName
    }
}
