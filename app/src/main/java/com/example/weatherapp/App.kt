package com.example.weatherapp

import android.app.Application
import com.example.weatherapp.koinDi.localDataModule
import com.example.weatherapp.koinDi.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(localDataModule, viewModelModule))
        }
    }
}