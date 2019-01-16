package com.example.inobitest.ui.comments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import com.example.inobitest.R
import com.example.inobitest.model.Comment
import kotlinx.android.synthetic.main.activity_comments.*
import kotlinx.android.synthetic.main.dialog_new_comment.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CommentsActivity : AppCompatActivity() {

    private val viewModel: CommentsViewModel by viewModel()
    private val adapter by lazy { CommentsAdapter(emptyList()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        val postId = intent.getIntExtra("POST_ID",1)
        rv_comment_list.adapter = adapter

        viewModel.getComments(postId).observe(this, Observer {
            adapter.comments = it
            adapter.notifyDataSetChanged()
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.comment_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

     when(item?.itemId){
        R.id.add_comment -> {
            showNewCommentDialog()
            return true
        }
    }
    return super.onOptionsItemSelected(item)
    }
    private fun showNewCommentDialog(){

        val builder = AlertDialog.Builder(this)
        builder.setTitle("New Comment")

        val view = layoutInflater.inflate(R.layout.dialog_new_comment, null)

        val inputName = view.edit_name
        val inputEmail = view.edit_email
        val inputBody = view.edit_comment_body

        builder.setView(view)
        builder.setPositiveButton("Добавить"){ dialog, _ ->
            val name = inputName.text
            val email = inputEmail.text
            val body = inputBody.text
            var isValid = true
            if(name.isBlank() || email.isBlank() || body.isBlank()){
                inputName.error = "Error"
                isValid = false
            }
            if(isValid){
                
                adapter.addNewComment(Comment(adapter.itemCount+1,name.toString(),email.toString(),body.toString()),adapter.itemCount)
                scrollToNewAddedItem()
                dialog.dismiss()
            }
        }
        builder.setNegativeButton("Cancel"){ dialog, which ->
            dialog.cancel()
        }
        builder.show()
    }
    private fun scrollToNewAddedItem(){
        rv_comment_list.scrollToPosition(adapter.itemCount-1)
    }
}
