package com.example.demoretrofit.Network

import androidx.lifecycle.MutableLiveData
import com.example.demoretrofit.Model.Result
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class NetworkModule() {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://randomuser.me")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideUserApi(retrofit: Retrofit): ApiUser {
        return retrofit.create(ApiUser::class.java)
    }
}