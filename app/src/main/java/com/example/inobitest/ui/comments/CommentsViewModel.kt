package com.example.inobitest.ui.comments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.inobitest.model.Comment
import com.example.inobitest.repository.CommentRepository
import com.example.inobitest.utils.BaseViewModel
import kotlinx.coroutines.launch

class CommentsViewModel(
    private val commentRepository: CommentRepository
): BaseViewModel() {
    fun getComments(postId: Int): LiveData<List<Comment>>{
        val mutableComments = MutableLiveData<List<Comment>>()
        launch {
            mutableComments.value = commentRepository.getComments(postId)
        }
        return mutableComments
    }
}