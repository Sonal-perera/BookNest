package com.booknest.personal.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.booknest.personal.R
import com.booknest.personal.adapter.FeaturedBooksAdapter
import com.booknest.personal.model.Books

class ExploreFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_explore, container, false)
        val context = view.context
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView9)

        val allBooks: MutableList<Books> = mutableListOf()

        allBooks.add(Books("The Silent Echo","Sarah Mitchell",19.99,4.5,R.drawable.book_5))
        allBooks.add(Books("Dark Matter","John Blake",50.99,4.5,R.drawable.book_1))
        allBooks.add(Books("Lost Dreams","Emma Roberts",30.99,4.5,R.drawable.book_3))
        allBooks.add(Books("The Last Secret","Mitchell Ross",23.99,4.5,R.drawable.book_6))
        allBooks.add(Books("Summer Love","Lisa Shen",18.99,4.5,R.drawable.book_4))
        allBooks.add(Books("Lost Dreams","Emma Roberts",30.99,4.5,R.drawable.book_5))
        val featuredBooksAdapter = FeaturedBooksAdapter(allBooks, context)

        val manager = GridLayoutManager(context,2)
        recyclerView.layoutManager = manager
        recyclerView.adapter = featuredBooksAdapter

        return view
    }
}