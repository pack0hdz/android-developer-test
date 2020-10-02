package com.exam.hugoapptest.base

import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.exam.hugoapptest.extensions.removeFromParent
import com.exam.hugoapptest.providers.BaseAndroidProvider

open class BaseActivity: AppCompatActivity(), BaseAndroidProvider {

    private val loadingView by lazy { LoadingView(this) }

    override fun showError(message: String) {
        dismissProgressDialog()
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showError(messageRes: Int) {
        dismissProgressDialog()
        Toast.makeText(this,  getString(messageRes), Toast.LENGTH_LONG).show()
    }

    override fun showMessage(message: String, iconSuccessAlert: Int?) {
        dismissProgressDialog()
        Toast.makeText(this,  message, Toast.LENGTH_LONG).show()
    }

    override fun showMessage(message: String) {
        dismissProgressDialog()
        Toast.makeText(this,  message, Toast.LENGTH_LONG).show()
    }

    override fun showMessage(@StringRes messageRes: Int) = showMessage(getString(messageRes))

    override fun showLoading(show: Boolean) {
        if (show) showProgressDialog() else dismissProgressDialog()
    }

    override fun showProgressDialog() {
        showProgressDialog("Cargando")
    }

    override fun dismissProgressDialog() {
        loadingView.removeFromParent()
    }

    private fun showProgressDialog(message: String) {
        loadingView.setMessage(message)
        if (loadingView.parent == null) {
            addContentView(
                loadingView, ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            )
        }
    }
}