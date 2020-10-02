package com.exam.hugoapptest.di.modules

import com.exam.hugoapptest.flow.home.fragments.OperationSelectionFragment
import com.exam.hugoapptest.scopes.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun providesSelectionOperation(): OperationSelectionFragment
}