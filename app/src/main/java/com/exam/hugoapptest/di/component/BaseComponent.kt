package com.exam.hugoapptest.di.component

import android.app.Application
import android.content.Context
import com.exam.hugoapptest.application.InjectableApplication
import com.google.gson.Gson
import dagger.android.AndroidInjector

interface BaseComponent : AndroidInjector<InjectableApplication> {

    fun context(): Context

    fun application(): Application

    fun gson(): Gson
}