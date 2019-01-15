package com.example.inobitest

import android.app.Application
import org.koin.android.architecture.ext.viewModel
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.applicationContext

class MyApplication: Application() {
    val application = org.koin.dsl.module.applicationContext {
        viewModel { PostViewModel(get()) }
    }
    override fun onCreate() {
        super.onCreate()
        startKoin(this, )
    }
}