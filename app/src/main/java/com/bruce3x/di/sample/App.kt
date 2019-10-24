package com.bruce3x.di.sample

import android.app.Application
import com.bruce3x.di.sample.koin.installKoin


class App : Application() {

    override fun onCreate() {
        super.onCreate()

       installKoin(this)
    }

}