package com.example.inobitest

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.post_list_item.view.*

class PostAdapter(private val postList : MutableList<Post>, private val context: Context) : RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.post_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mPostTitle.text = postList[position].toString()
        holder.mPostBody.text = postList[position].toString()
    }

}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    val mPostTitle = view.tv_post_title!!
    val mPostBody= view.tv_post_body!!
}
