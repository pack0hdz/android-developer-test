package com.exam.hugoapptest.providers

import androidx.annotation.StringRes

interface BaseAndroidProvider {

    fun showError(message: String)

    fun showError(@StringRes messageRes: Int)

    fun showMessage(message: String, iconSuccessAlert: Int? = null)

    fun showMessage(message: String)

    fun showMessage(@StringRes messageRes: Int)

    fun showLoading(show: Boolean)

    fun showProgressDialog()

    fun dismissProgressDialog()

}