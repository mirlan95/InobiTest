package com.example.inobitest.ui.posts

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.inobitest.R
import com.example.inobitest.model.Post
import com.example.inobitest.utils.inflate
import kotlinx.android.synthetic.main.post_list_item.view.*

class PostsAdapter(
    var posts: List<Post>,
    private val onPostClick: (Post) -> Unit
): RecyclerView.Adapter<PostsAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.post_list_item))
    }
    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        init {
            itemView.setOnClickListener {
                onPostClick(posts[adapterPosition])
            }
        }
        fun bind(post: Post){
            itemView.tv_post_title.text = post.title
            itemView.tv_post_body.text = post.body
        }
    }
}