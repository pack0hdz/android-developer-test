package com.exam.hugoapptest.application

import com.exam.hugoapptest.di.component.DaggerMainComponent
import com.exam.hugoapptest.di.component.MainComponent
import com.exam.hugoapptest.preference.PrefsManager

class MainApplication : ExamenApplication() {

    companion object {
        lateinit var instance: MainApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        PrefsManager.init(this)
    }

    private fun getMainComponent() = component as MainComponent

    override fun initializeInjector() {
        component = DaggerMainComponent.builder()
            .application(this)
            .build()
            .apply { inject(this@MainApplication) }
    }
}