package com.exam.hugoapptest.di.component

import com.exam.hugoapptest.application.InjectableApplication
import com.exam.hugoapptest.di.modules.ExamenAppModule
import com.exam.hugoapptest.di.modules.ExamenModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ExamenAppModule::class,
        ExamenModule::class,
        AndroidSupportInjectionModule::class
    ]
)
interface MainComponent : BaseComponent {

    @Component.Builder
    interface Builder {
        fun build(): MainComponent

        @BindsInstance
        fun application(application: InjectableApplication): Builder
    }
}