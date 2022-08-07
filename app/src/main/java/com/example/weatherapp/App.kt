package com.example.weatherapp

import android.app.Application
import com.example.weatherapp.koinDi.localDataModule
import com.example.weatherapp.koinDi.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

/**
 * This [App] class is used to startKoin and implement the specific modules being used in the app
 * ([localDataModule] and [viewModelModule]), which are contianed in the koinDi Package.
 */

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(localDataModule, viewModelModule))
        }
    }
}