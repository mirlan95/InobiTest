package com.example.inobitest.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.inobitest.model.Post

class PostRepository(private val apiInterface: ApiInterface) {
    suspend fun getPosts(): List<Post> {
        return apiInterface.getPosts().await()
    }
}