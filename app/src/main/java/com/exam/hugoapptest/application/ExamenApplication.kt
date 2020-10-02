package com.exam.hugoapptest.application

import com.exam.hugoapptest.di.component.BaseComponent

abstract class ExamenApplication : InjectableApplication() {
    var component: BaseComponent? = null
        protected set

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        var instance: ExamenApplication? = null
            private set
    }
}