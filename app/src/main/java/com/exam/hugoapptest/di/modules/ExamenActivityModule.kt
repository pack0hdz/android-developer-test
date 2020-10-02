package com.exam.hugoapptest.di.modules

import com.exam.hugoapptest.flow.home.HomeActivity
import com.exam.hugoapptest.scopes.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ExamenActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            HomeModule::class
        ]
    )
    abstract fun bindHomeActivity(): HomeActivity
}