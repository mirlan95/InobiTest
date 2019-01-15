package com.example.inobitest

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class PostViewModel(val postRepository: PostRepository): ViewModel() {
    val postList = MutableLiveData<List<Post>>()
    fun getPost(){

    }
}