package com.example.inobitest.ui.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.inobitest.model.Post
import com.example.inobitest.repository.PostRepository
import com.example.inobitest.utils.BaseViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PostsViewModel(
    private val postRepository: PostRepository
) : BaseViewModel() {
    val posts: LiveData<List<Post>>
        get() {
            val mutablePosts = MutableLiveData<List<Post>>()
            launch {
                mutablePosts.value = postRepository.getPosts()
            }
            return mutablePosts
        }
}