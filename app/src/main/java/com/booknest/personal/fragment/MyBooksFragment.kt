package com.booknest.personal.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.booknest.personal.R
import com.booknest.personal.fragment.ProfileFragment
import com.booknest.personal.activity.NewBookActivity
import com.booknest.personal.adapter.MyBooksAdapter
import com.booknest.personal.model.Books
import com.google.android.material.appbar.MaterialToolbar

class MyBooksFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my_books, container, false)
        val context = view.context
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView8)
        val toolbar = view.findViewById<MaterialToolbar>(R.id.materialToolbar5)
        val fragmentId = R.id.fragmentContainerView

        toolbar.setTitle("My Books")
        val myBooks: MutableList<Books> = mutableListOf()

        myBooks.add(Books("The Silent Echo","Sarah Mitchell",19.99,4.5,R.drawable.book_5))
        myBooks.add(Books("Dark Matter","John Blake",50.99,4.5,R.drawable.book_1))
        myBooks.add(Books("Lost Dreams","Emma Roberts",30.99,4.5,R.drawable.book_3))
        val myBooksAdapter = MyBooksAdapter(myBooks, context)

        val manager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = manager
        recyclerView.adapter = myBooksAdapter

        toolbar.setNavigationOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(fragmentId, ProfileFragment())?.commit()
        }

        toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.app_bar_search1 -> {
                    // Handle search action
                    true
                }

                R.id.nav_add -> {
                    // Handle new books
                    val intent = Intent(requireContext(), NewBookActivity::class.java)
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }


        return view
    }
}