package com.example.inobitest.repository

import com.example.inobitest.model.Comment


class CommentRepository(private val apiInterface: ApiInterface) {
    suspend fun getComments(postId: Int): List<Comment>{
        return apiInterface.getComments(postId).await()
    }
}