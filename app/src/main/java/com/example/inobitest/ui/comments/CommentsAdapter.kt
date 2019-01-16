package com.example.inobitest.ui.comments

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.inobitest.R
import com.example.inobitest.model.Comment
import com.example.inobitest.utils.inflate
import kotlinx.android.synthetic.main.comment_list_item.view.*

class CommentsAdapter(
    var comments: List<Comment>
): RecyclerView.Adapter<CommentsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.comment_list_item))
    }

    override fun getItemCount() = comments.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(comments[position])
    }
    fun addNewComment(comment: Comment, itemCount: Int){
        (comments as MutableList<Comment>).add(itemCount,comment)
        notifyItemInserted(itemCount)
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        fun bind(comment: Comment){
            itemView.tv_name.text = comment.name
            itemView.tv_email.text = comment.email
            itemView.tv_comment_body.text = comment.body
        }

    }
}


