package com.kospavel.androidtest.di

import com.kospavel.androidtest.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}
