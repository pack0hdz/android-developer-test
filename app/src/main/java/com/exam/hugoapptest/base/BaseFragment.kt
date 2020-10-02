package com.exam.hugoapptest.base

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.exam.hugoapptest.base.BaseActivity
import com.exam.hugoapptest.providers.BaseAndroidProvider

abstract class BaseFragment : Fragment(), BaseAndroidProvider {

    val hugoBaseActivity by lazy {
        requireActivity() as BaseActivity
    }

    override fun showError(@StringRes messageRes: Int) {
        hugoBaseActivity.showError(messageRes)
    }

    override fun showError(message: String) {
        hugoBaseActivity.showError(message)
    }

    override fun showMessage(message: String, iconSuccessAlert: Int?) {
        hugoBaseActivity.showMessage(message, iconSuccessAlert)
    }

    override fun showMessage(@StringRes messageRes: Int) {
        hugoBaseActivity.showMessage(messageRes)
    }

    override fun showMessage(message: String) {
        hugoBaseActivity.showMessage(message)
    }

    override fun showLoading(show: Boolean) {
        hugoBaseActivity.showLoading(show)
    }

    override fun dismissProgressDialog() {
        hugoBaseActivity.dismissProgressDialog()
    }

    override fun showProgressDialog() {
        hugoBaseActivity.showProgressDialog()
    }
}