package com.example.inobitest.repository

import com.example.inobitest.model.Comment
import com.example.inobitest.model.Post
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("posts")
    fun getPosts(): Deferred<List<Post>>

    @GET("comments/{postId}")
    fun getComments(@Query("postId") postId:Int): Deferred<List<Comment>>
}