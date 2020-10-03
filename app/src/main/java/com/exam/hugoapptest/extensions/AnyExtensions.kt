package com.exam.hugoapptest.extensions

import androidx.lifecycle.MutableLiveData

fun Any.simpleClassName(): String = this::class.java.simpleName

fun CharSequence?.isNotNullOrBlank(): Boolean {
    return this.isNullOrBlank().not()
}

fun <T> MutableLiveData<T>.default(default: T): MutableLiveData<T> {
    return this.apply {
        value = default
    }
}