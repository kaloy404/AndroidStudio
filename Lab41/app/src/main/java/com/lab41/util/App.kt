package com.lab41.util

import android.app.Application
import com.lab41.data.Loader
import com.lab41.data.RealLoader

open class App : Application() {
    open fun provideLoader(): Loader = RealLoader()

    override fun onCreate() {
        super.onCreate()
        // any app init
    }
}
