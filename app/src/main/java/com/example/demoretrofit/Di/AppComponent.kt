package com.example.demoretrofit.Di

import android.app.Application
import com.example.demoretrofit.MainActivity
import com.example.demoretrofit.Network.ApiUser
import com.example.demoretrofit.Network.NetworkModule
import com.example.demoretrofit.ViewModel.ActivityMainViewModel
import dagger.BindsInstance
import dagger.Component
import dagger.Component.Builder
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
interface AppComponent {
    fun inject(viewModel: ActivityMainViewModel)
    fun inject(application: Application)
    fun inject(mainActivity: MainActivity)

    fun getUserApi(): ApiUser
}