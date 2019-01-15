package com.example.inobitest

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.architecture.ext.viewModel

class MainActivity : AppCompatActivity() {

    val postViewModel by viewModel<PostViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_post_list.layoutManager = LinearLayoutManager(this)
        postViewModel.postList.observe(this, Observer {
            rv_post_list.adapter = PostAdapter(it, this)
        })




    }
}
