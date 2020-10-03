package com.exam.hugoapptest.flow.home

import android.os.Bundle
import com.exam.hugoapptest.R
import com.exam.hugoapptest.base.BaseActivity
import com.exam.hugoapptest.extensions.simpleClassName
import com.exam.hugoapptest.flow.home.fragments.OperationSelectionFragment
import com.exam.hugoapptest.flow.home.fragments.RegisterNewCarFragment
import com.exam.hugoapptest.flow.home.fragmentsheet.RegisterNewAccessFragmentSheet
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class HomeActivity : BaseActivity(),
    HasAndroidInjector,
    OperationSelectionFragment.OperationListener {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onRegisterNewAccess() {
        RegisterNewAccessFragmentSheet.newInstance().apply {
            show(supportFragmentManager, simpleClassName())
        }
    }

    override fun onRegisterExist() {
        TODO("Not yet implemented")
    }

    override fun onRegisterNewCar() {
        TODO("Not yet implemented")
    }

    override fun onStartMonth() {
        TODO("Not yet implemented")
    }

    override fun onPaymentResident() {
        TODO("Not yet implemented")
    }
}