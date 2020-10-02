package com.exam.hugoapptest.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel: ViewModel() {
    protected val disposable = CompositeDisposable()

    protected val showProgress = MutableLiveData<Boolean>()
    protected val showMessage = MutableLiveData<Int>()
    protected val showMessageText = MutableLiveData<String>()
    protected val showError = MutableLiveData<Int>()
    protected val showErrorMessage = MutableLiveData<String>()

    fun getShowProgress(): LiveData<Boolean> = showProgress
    fun getShowMessage(): LiveData<Int> = showMessage
    fun getShowMessageText(): LiveData<String> = showMessageText
    fun getShowError(): LiveData<Int> = showError
    fun getShowErrorMessage(): LiveData<String> = showErrorMessage

    override fun onCleared() {
        disposable.clear()
    }
}