package com.example.inobitest

import android.app.Application
import com.example.inobitest.repository.ApiInterface
import com.example.inobitest.repository.PostRepository
import com.example.inobitest.ui.posts.PostsViewModel
import com.example.inobitest.utils.Constants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import org.koin.android.ext.android.startKoin
import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(getModule()))
    }

    private fun getModule() = module {
        single { OkHttpClient().newBuilder().build() }
        single {
            Retrofit.Builder()
                .client(get())
                .baseUrl(Constants.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
                .create(ApiInterface::class.java)
        }

        single { PostRepository(get()) }

        viewModel { PostsViewModel(get()) }
    }
}