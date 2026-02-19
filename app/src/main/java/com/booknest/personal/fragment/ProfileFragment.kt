package com.booknest.community.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.booknest.community.R
import com.booknest.community.activity.CheckoutActivity
import com.booknest.community.activity.DesignedBooksActivity
import com.booknest.community.activity.NewBookActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val context = view.context;
        val toolbar = view.findViewById<MaterialToolbar>(R.id.materialToolbar4)
        val orderBtn = view.findViewById<TextView>(R.id.textView113)
        val addressBtn = view.findViewById<TextView>(R.id.textView114)
        val paymentBtn = view.findViewById<TextView>(R.id.textView115)
        val wishlistBtn = view.findViewById<TextView>(R.id.textView116)
        val reviewsBtn = view.findViewById<TextView>(R.id.textView117)
        val designBtn = view.findViewById<TextView>(R.id.textView118)
        val myBooksBtn = view.findViewById<TextView>(R.id.textView119)
        val bottom: BottomNavigationView? = activity?.findViewById(R.id.bottomNavigationView)
        val fragmentId = R.id.fragmentContainerView


        toolbar.setTitle("My Account")
        toolbar.isTitleCentered = true
        val animation = AnimationUtils.loadAnimation(context, R.anim.flash)

        orderBtn.setOnClickListener {
            orderBtn.startAnimation(animation)
            bottom?.selectedItemId = R.id.nav_orders
        }

        designBtn.setOnClickListener {
            designBtn.startAnimation(animation)
            val intent = Intent(requireContext(), NewBookActivity::class.java)
            startActivity(intent)
        }

        myBooksBtn.setOnClickListener {
            myBooksBtn.startAnimation(animation)
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(fragmentId, MyBooksFragment())?.commit()
        }

        addressBtn.setOnClickListener {
            addressBtn.startAnimation(animation)
        }
        paymentBtn.setOnClickListener {
            paymentBtn.startAnimation(animation)
        }
        wishlistBtn.setOnClickListener {
            wishlistBtn.startAnimation(animation)
        }
        reviewsBtn.setOnClickListener {
            reviewsBtn.startAnimation(animation)
        }
        return view
    }

}