package com.example.demoretrofit.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoretrofit.Di.DaggerAppComponent
import com.example.demoretrofit.Di.DaggerAppComponent.builder
import com.example.demoretrofit.Model.ResponseData
import com.example.demoretrofit.Model.Result
import com.example.demoretrofit.Network.ApiUser
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class ActivityMainViewModel: ViewModel() {

    @Inject
    lateinit var userApi: ApiUser
    lateinit var listResult : MutableLiveData<List<Result>>

    val TAG = "demoRetrofit"

    init {
        listResult = MutableLiveData<List<Result>>().apply {
            value = listOf()
        }

        DaggerAppComponent.create().inject(this)

        val call = userApi.getUsers(20)

        call.enqueue(object : retrofit2.Callback<ResponseData>{
            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                if(response.isSuccessful) {
                    response.body()?.let {
                        listResult.value = it.results
                    }
                }
            }

            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                Log.d(TAG, "onFailure")
            }

        })

    }
}

