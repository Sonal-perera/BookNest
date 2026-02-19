package com.booknest.personal.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.booknest.personal.R
import com.booknest.personal.fragment.ShippingFragment
import com.booknest.personal.adapter.CartAdapter
import com.booknest.personal.model.Cart
import com.google.android.material.appbar.MaterialToolbar

class CartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cart, container, false)
        val context = view.context
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView4)
        val nextBtn = view.findViewById<Button>(R.id.button12)
        val fragmentId = R.id.fragmentContainerView2


        val cartIndicator = activity?.findViewById<TextView>(R.id.textView36)
        val cartIndicatorText = activity?.findViewById<TextView>(R.id.textView39)
        val shippingIndicator = activity?.findViewById<TextView>(R.id.textView37)
        val toolbar = activity?.findViewById<MaterialToolbar>(R.id.materialToolbar3)

        val cartItems: MutableList<Cart> = mutableListOf()

        cartItems.add(
            Cart(
                "12357",
                "The Silent Echo",
                "Sarah Mitchell",
                R.drawable.book_3,
                19.55,
                1
            )
        )
        cartItems.add(Cart("753743", "The Last Secret", "John Blake", R.drawable.book_1, 30.0, 2))
        cartItems.add(
            Cart(
                "7325432",
                "Rich dad poor dad",
                "Emma Roberts",
                R.drawable.book_5,
                25.99,
                2
            )
        )
        val featuredBooksAdapter = CartAdapter(cartItems, context)

        val manager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = manager
        recyclerView.adapter = featuredBooksAdapter

        nextBtn.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(fragmentId, ShippingFragment())?.commit()

            cartIndicator?.setTextColor(context.getColor(R.color.black))
            cartIndicator?.setBackgroundResource(R.drawable.unselected_circle)
            cartIndicatorText?.setTextColor(context.getColor(R.color.primary))

            shippingIndicator?.setTextColor(context.getColor(R.color.white))
            shippingIndicator?.setBackgroundResource(R.drawable.selected_circle)

            toolbar?.setTitle("Shipping Details")
        }

        return view
    }
}