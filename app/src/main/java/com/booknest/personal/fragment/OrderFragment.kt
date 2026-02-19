package com.booknest.community.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.booknest.community.R
import com.booknest.community.adapter.CustomSelectorAdapter
import com.booknest.community.adapter.FeaturedBooksAdapter
import com.booknest.community.adapter.NewBooksAdapter
import com.booknest.community.adapter.OrdersAdapter
import com.booknest.community.model.Books
import com.booknest.community.model.Order
import com.booknest.community.model.Status
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.Date

class OrderFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_order, container, false)
        val context = view.context;
        val toolbar = view.findViewById<MaterialToolbar>(R.id.materialToolbar)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView2)
        val recyclerView1 = view.findViewById<RecyclerView>(R.id.recyclerView3)
        val fragmentId = R.id.fragmentContainerView
        val bottom = activity?.findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        toolbar.setTitle("Orders")
        toolbar.isTitleCentered = false
        toolbar.setTitleTextColor(context.getColor(R.color.text_color1))

        toolbar.setNavigationOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(fragmentId, HomeFragment())
                ?.commit()

            if (bottom != null) {
                bottom.selectedItemId = R.id.nav_home
            };
        }

        val status: MutableList<Status> = mutableListOf()

        status.add(Status("All Orders"))
        status.add(Status("Delivered"))
        status.add(Status("Processing"))
        status.add(Status("Cancelled"))
        val statusAdapter = CustomSelectorAdapter(status, context) { it.name }

        val manager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.layoutManager = manager
        recyclerView.adapter = statusAdapter

        //load Order details
        val ordersList: MutableList<Order> = mutableListOf()

        ordersList.add(
            Order(
                "#1234",
                "sonalperera0@gmail.com",
                "March 15, 2025",
                "The Silent Echo",
                "Sarah Mitchell",
                R.drawable.book_3,
                28.99,
                "Processing"
            )
        )
        ordersList.add(
            Order(
                "#84516",
                "sonalpererao@gmail.com",
                "March 25, 2025",
                "The Silent Echo",
                "Sarah Mitchell",
                R.drawable.book_1,
                28.99,
                "Cancelled"
            )
        )
        ordersList.add(
            Order(
                "#7110",
                "sonalperera0@gmail.com",
                "March 30, 2025",
                "The Silent Echo",
                "Sarah Mitchell",
                R.drawable.book_5,
                16.99,
                "Delivered"
            )
        )
        val orderAdapter = OrdersAdapter(ordersList, context)

        val manager2 = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView1.layoutManager = manager2
        recyclerView1.adapter = orderAdapter

        return view;
    }
}