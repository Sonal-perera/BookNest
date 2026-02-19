package com.booknest.personal.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.booknest.personal.R
import com.booknest.personal.activity.ConfirmationActivity
import com.booknest.personal.adapter.OrderSummaryAdapter
import com.booknest.personal.model.Cart
import com.google.android.material.radiobutton.MaterialRadioButton

class PaymentFragment : Fragment() {
    private lateinit var radio1: MaterialRadioButton
    private lateinit var radio2: MaterialRadioButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_payment, container, false)
        val context = view.context
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView6)
        radio1 = view.findViewById(R.id.radioButton4)
        radio2 = view.findViewById(R.id.radioButton5)
        val nextBtn = view.findViewById<Button>(R.id.button14)

        radio1.isChecked = true

        radio1.setOnClickListener {
           setRadioButtonGroup(radio1)
        }
        radio2.setOnClickListener {
            setRadioButtonGroup(radio2)

        }

        val ordersList: MutableList<Cart> = mutableListOf()

        ordersList.add(
            Cart(
                "12357",
                "The Silent Echo",
                "Sarah Mitchell",
                R.drawable.book_3,
                19.55,
                1
            )
        )
        ordersList.add(
            Cart(
                "7325432",
                "Rich dad poor dad",
                "Emma Roberts",
                R.drawable.book_5,
                25.99,
                2
            )
        )
        val orderSummaryAdapter = OrderSummaryAdapter(ordersList, context)

        val manager2 = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = manager2
        recyclerView.adapter = orderSummaryAdapter

        nextBtn.setOnClickListener {
            val intent = Intent(requireContext(), ConfirmationActivity::class.java)
            startActivity(intent)
            activity?.finish();
        }
        return view;
    }

    private fun setRadioButtonGroup(selected: MaterialRadioButton) {
        radio1.isChecked = selected == radio1
        radio2.isChecked = selected == radio2
    }
}