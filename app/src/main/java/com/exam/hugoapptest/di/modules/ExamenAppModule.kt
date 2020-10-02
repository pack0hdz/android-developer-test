package com.exam.hugoapptest.di.modules

import android.app.Application
import android.content.Context
import com.exam.hugoapptest.application.InjectableApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object ExamenAppModule {

    @Provides
    @Singleton
    @JvmStatic
    fun providesContext(app: InjectableApplication): Context = app.applicationContext

    @Provides
    @Singleton
    @JvmStatic
    fun providesApplication(app: InjectableApplication): Application = app
}