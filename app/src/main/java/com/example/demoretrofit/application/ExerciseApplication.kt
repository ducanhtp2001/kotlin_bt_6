package com.example.demoretrofit.application

import android.app.Application
import com.example.demoretrofit.Di.AppComponent
import com.example.demoretrofit.Di.DaggerAppComponent

class ExerciseApplication: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
        appComponent.inject(this)
    }
}