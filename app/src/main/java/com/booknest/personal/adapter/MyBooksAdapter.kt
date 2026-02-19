package com.booknest.community.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.booknest.community.R
import com.booknest.community.activity.NewBookActivity
import com.booknest.community.model.Books
import com.booknest.community.model.Cart
import com.booknest.community.model.Order

class MyBooksAdapter(private val myBooks: List<Books>, private val context: Context) :
    RecyclerView.Adapter<MyBooksAdapter.MyBooksVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyBooksVH {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.my_books_view, parent, false)
        return MyBooksVH(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyBooksVH, position: Int) {
        val myBook = myBooks[position]
        val animation = AnimationUtils.loadAnimation(context, R.anim.flash)

        holder.bookName.text = myBook.name
        holder.author.text = myBook.author;
        holder.image.setImageResource(myBook.image)
        holder.card.setOnClickListener {
            holder.card.startAnimation(animation)
        }

    }

    override fun getItemCount(): Int = myBooks.size

    class MyBooksVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bookName: TextView = itemView.findViewById(R.id.textView143)
        val author: TextView = itemView.findViewById(R.id.textView144)
        val image: ImageView = itemView.findViewById(R.id.imageView12)
        val card = itemView
    }
}