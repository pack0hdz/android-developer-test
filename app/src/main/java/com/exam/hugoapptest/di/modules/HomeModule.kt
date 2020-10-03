package com.exam.hugoapptest.di.modules

import com.exam.hugoapptest.flow.home.fragments.OperationSelectionFragment
import com.exam.hugoapptest.flow.home.fragments.RegisterNewCarFragment
import com.exam.hugoapptest.flow.home.fragmentsheet.RegisterNewAccessFragmentSheet
import com.exam.hugoapptest.scopes.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun providesSelectionOperation(): OperationSelectionFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun providesRegisterNewCarFragment(): RegisterNewCarFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun providesNewAccessFragmentSheet(): RegisterNewAccessFragmentSheet
}