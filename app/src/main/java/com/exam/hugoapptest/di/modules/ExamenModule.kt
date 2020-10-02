package com.exam.hugoapptest.di.modules

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class ExamenModule {
    @Provides
    @Reusable
    fun provideGson(): Gson = Gson()
}