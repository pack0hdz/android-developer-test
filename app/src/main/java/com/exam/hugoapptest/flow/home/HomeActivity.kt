package com.exam.hugoapptest.flow.home

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.exam.hugoapptest.R
import com.exam.hugoapptest.base.BaseActivity
import com.exam.hugoapptest.extensions.simpleClassName
import com.exam.hugoapptest.flow.home.config.RegisterConfig
import com.exam.hugoapptest.flow.home.config.RegisterOperation
import com.exam.hugoapptest.flow.home.fragments.OperationSelectionFragment
import com.exam.hugoapptest.flow.home.fragments.OperationSelectionFragmentDirections
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

    fun currentNavController(): NavController = findNavController(R.id.navHostFragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onRegisterNewAccess() {
        val registerConfig = RegisterConfig(
            getString(R.string.fragment_sheet_register_access_title),
            getString(R.string.fragment_sheet_register_access_time),
            RegisterOperation.ACCESS
        )
        RegisterNewAccessFragmentSheet.newInstance(registerConfig).apply {
            show(supportFragmentManager, simpleClassName())
        }
    }

    override fun onRegisterExist() {
        val registerConfig = RegisterConfig(
            getString(R.string.fragment_sheet_register_exit_title),
            getString(R.string.fragment_sheet_register_exit_time),
            RegisterOperation.EXIT
        )
        RegisterNewAccessFragmentSheet.newInstance(registerConfig).apply {
            show(supportFragmentManager, simpleClassName())
        }
    }

    override fun onRegisterNewCar() {
        currentNavController().navigate(OperationSelectionFragmentDirections.actionToNewCarFragment())
    }

    override fun onStartMonth() {
        TODO("Not yet implemented")
    }

    override fun onPaymentResident() {
        TODO("Not yet implemented")
    }
}