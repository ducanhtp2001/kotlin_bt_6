package com.example.demoretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.demoretrofit.Adapter.MyAdapter
import com.example.demoretrofit.Di.DaggerAppComponent
import com.example.demoretrofit.ViewModel.ActivityMainViewModel
import com.example.demoretrofit.application.ExerciseApplication
import com.example.demoretrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: ActivityMainViewModel

    lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var appComponent = (application as ExerciseApplication).appComponent
        appComponent.inject(this)

        viewModel = ViewModelProvider(this).get(ActivityMainViewModel::class.java)
        viewModel.listResult.observe(this, Observer {
            adapter = MyAdapter(this, R.layout.result_layout, viewModel.listResult.value!!)
            binding.listView.adapter = adapter
        })
    }
}