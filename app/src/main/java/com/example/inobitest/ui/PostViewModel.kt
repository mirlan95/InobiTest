package com.example.inobitest.ui

import androidx.lifecycle.ViewModel
import com.example.inobitest.model.Post
import com.example.inobitest.repository.PostRepository
import androidx.lifecycle.LiveData



class PostViewModel(val postRepository: PostRepository): ViewModel() {
    //val postList = MutableLiveData<List<Post>>()
    private val postList: LiveData<List<Post>>? = null

    fun getPostListObservable(): LiveData<List<Post>>? {
        return postList
    }
}