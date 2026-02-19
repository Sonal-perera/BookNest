package com.booknest.personal.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.booknest.personal.R
import com.booknest.personal.adapter.OrderSummaryAdapter
import com.booknest.personal.fragment.PaymentFragment
import com.booknest.personal.model.Cart
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.radiobutton.MaterialRadioButton

class ShippingFragment : Fragment() {

    private lateinit var radio1: MaterialRadioButton
    private lateinit var radio2: MaterialRadioButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_shipping, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView5)
        val nextBtn = view.findViewById<Button>(R.id.button13)
        radio1 = view.findViewById(R.id.radioButton2)
        radio2 = view.findViewById(R.id.radioButton3)
        val fragmentId = R.id.fragmentContainerView2

        val shippingIndicator = activity?.findViewById<TextView>(R.id.textView37)
        val shippingIndicatorText = activity?.findViewById<TextView>(R.id.textView40)
        val paymentIndicator = activity?.findViewById<TextView>(R.id.textView38)
        val toolbar = activity?.findViewById<MaterialToolbar>(R.id.materialToolbar3)

        radio1.setOnClickListener { setRadioButtonGroup(radio1) }
        radio2.setOnClickListener { setRadioButtonGroup(radio2) }

        // Default selection
        radio1.isChecked = true

        val ordersList = mutableListOf(
            Cart(
                "12357",
                "The Silent Echo",
                "Sarah Mitchell",
                R.drawable.book_3,
                19.55,
                1
            ),
            Cart("753743", "The Last Secret", "John Blake", R.drawable.book_1, 30.0, 2),
            Cart(
                "7325432",
                "Rich dad poor dad",
                "Emma Roberts",
                R.drawable.book_5,
                25.99,
                2
            )
        )

        val orderSummaryAdapter = OrderSummaryAdapter(ordersList, requireContext())
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        recyclerView.adapter = orderSummaryAdapter

        nextBtn.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(fragmentId, PaymentFragment())
                ?.commit()

            shippingIndicator?.setTextColor(requireContext().getColor(R.color.black))
            shippingIndicator?.setBackgroundResource(R.drawable.unselected_circle)
            shippingIndicatorText?.setTextColor(requireContext().getColor(R.color.primary))

            paymentIndicator?.setTextColor(requireContext().getColor(R.color.white))
            paymentIndicator?.setBackgroundResource(R.drawable.selected_circle)

            toolbar?.title = "Payment Details"
        }

        return view
    }

    private fun setRadioButtonGroup(selected: MaterialRadioButton) {
        radio1.isChecked = selected == radio1
        radio2.isChecked = selected == radio2
    }
}