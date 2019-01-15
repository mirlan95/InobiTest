package com.example.inobitest.ui.posts

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.inobitest.R
import com.example.inobitest.model.Post
import com.example.inobitest.ui.comments.CommentsActivity
import kotlinx.android.synthetic.main.activity_posts.*
import kotlinx.android.synthetic.main.post_list_item.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostsActivity : AppCompatActivity() {
    private val viewModel: PostsViewModel by viewModel()
    private val adapter by lazy { PostsAdapter(emptyList(), this::onPostClick) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)
        rv_post_list.adapter = adapter

        viewModel.posts.observe(this, Observer {
            adapter.posts = it
            adapter.notifyDataSetChanged()
        })
    }

    private fun onPostClick(post: Post) {
        //Toast.makeText(this, post.title, Toast.LENGTH_SHORT).show()
        val intent = Intent(this,CommentsActivity::class.java)
        startActivity(intent.putExtra("POST_ID", post.id))
    }

}