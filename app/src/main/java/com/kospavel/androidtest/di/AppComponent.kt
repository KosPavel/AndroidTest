package com.kospavel.androidtest.di

import com.kospavel.androidtest.ui.mainfeed.MainFeedFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {

    fun inject(mainFeedFragment: MainFeedFragment)
}