package com.booknest.personal.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.booknest.personal.R
import com.booknest.personal.model.Cart

class PaymentOrderAdapter(private val orders: List<Cart>, private val context: Context) :
    RecyclerView.Adapter<PaymentOrderAdapter.PaymentOrderVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentOrderVH {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.payment_order_view, parent, false)
        return PaymentOrderVH(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PaymentOrderVH, position: Int) {
        val order = orders[position]

        holder.bookName.text = order.name
        holder.author.text = order.author;
        holder.image.setImageResource(order.image)

    }

    override fun getItemCount(): Int = orders.size

    class PaymentOrderVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bookName: TextView = itemView.findViewById(R.id.textView93)
        val author: TextView = itemView.findViewById(R.id.textView104)
        val image: ImageView = itemView.findViewById(R.id.imageView8)
    }
}